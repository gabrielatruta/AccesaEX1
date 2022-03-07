package com.example.mentoringv1ex2.Service;

import com.example.mentoringv1ex2.Repository.DeviceRepository;
import com.example.mentoringv1ex2.Repository.SensorRepository;
import com.example.mentoringv1ex2.Repository.UserRepository;
import com.example.mentoringv1ex2.dto.DeviceDTO;
import com.example.mentoringv1ex2.mapper.DeviceMapper;
import com.example.mentoringv1ex2.model.Device;
import com.example.mentoringv1ex2.model.Sensor;
import com.example.mentoringv1ex2.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;
    private final UserRepository userRepository;
    private final SensorRepository sensorRepository;

    public Device findByID(Long id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Device with ID = " + id + " not found!"));
    }

    public List<DeviceDTO> findAll() {
        return  deviceRepository.findAll().stream()
                .map(deviceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<DeviceDTO> findOwnedDevicesForUser(Long userID) {
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new EntityNotFoundException("User with ID = " + userID + " not found!"));

        return deviceRepository.findDevicesByUser(user).stream()
                .map(deviceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DeviceDTO create(DeviceDTO deviceDTO) {

        userRepository.findById(deviceDTO.getUser())
                .orElseThrow(()-> new EntityNotFoundException("User with ID = " + deviceDTO.getUser() + " not found!"));

        return deviceMapper.toDTO(deviceRepository.save(deviceMapper.fromDTO(deviceDTO)));

    }

    public DeviceDTO edit(Long id, DeviceDTO deviceDTO) {
        Device actDevice = findByID(id);
        User user = userRepository.findById(deviceDTO.getUser())
                .orElseThrow(() -> new EntityNotFoundException("User with ID = " + deviceDTO.getUser() + " not found!"));

        actDevice.setLocation(deviceDTO.getLocation());
        actDevice.setDescription(deviceDTO.getDescription());
        actDevice.setMaximumConsumption(deviceDTO.getMaximumConsumption());
        actDevice.setAverageConsumption(deviceDTO.getAverageConsumption());
        actDevice.setUser(user);

        return deviceMapper.toDTO(deviceRepository.save(actDevice));

    }

    public void delete(Long id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("No device with such id!"));
        Sensor sensor = sensorRepository.findSensorsByDevice(device);
        if (sensor != null)
            sensorRepository.deleteById(sensor.getId());

        deviceRepository.deleteById(id);
    }

    public void deleteAll(){
        deviceRepository.deleteAll();
    }

}
