package com.example.mentoringv1ex2.Service;

import com.example.mentoringv1ex2.Repository.DeviceRepository;
import com.example.mentoringv1ex2.Repository.RoleRepository;
import com.example.mentoringv1ex2.Repository.UserRepository;
import com.example.mentoringv1ex2.dto.UserDTO;
import com.example.mentoringv1ex2.mapper.UserMapper;
import com.example.mentoringv1ex2.model.Device;
import com.example.mentoringv1ex2.model.ERole;
import com.example.mentoringv1ex2.model.Role;
import com.example.mentoringv1ex2.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final DeviceRepository deviceRepository;
    private final DeviceService deviceService;

    public List<UserDTO> allUsers() {
        return  userRepository.findAll()
                .stream().map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    private User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    public UserDTO create(UserDTO user) {
        Role defaultRole = roleRepository.findByName(ERole.CLIENT)
                .orElseThrow(() -> new RuntimeException("Cannot find CLIENT role"));
        User user1 = userMapper.fromDTO(user);
        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);
        user1.setRoles(roles);
        user1.setPassword(user.getPassword());
        
        return userMapper.toDTO(userRepository.save(user1));
    }

    public UserDTO edit(Long id, UserDTO user) {
        User actUser = findById(id);

        actUser.setEmail(user.getEmail());
        actUser.setUsername(user.getUsername());
        actUser.setPassword(user.getPassword());
        actUser.setAddress(user.getAddress());
        actUser.setBirthday(user.getBirthday());

        return userMapper.toDTO(
                userRepository.save(actUser)
        );

    }

    public void deleteById(Long id) {
        User user = findById(id);

        if (!deviceRepository.findDevicesByUser(user).isEmpty()) {
            for (Device device: deviceRepository.findDevicesByUser(user)) {
                deviceService.delete(device.getId());
            }
        }
        userRepository.deleteById(id);
    }

    public void deleteAll() { userRepository.deleteAll(); }

    public UserDTO get(Long id) {
        return userMapper.toDTO(findById(id));
    }
}
