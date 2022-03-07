package com.example.mentoringv1ex2.mapper;


import com.example.mentoringv1ex2.model.User;
import com.example.mentoringv1ex2.dto.UserDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);
    User fromDTO(UserDTO userDTO);

}
