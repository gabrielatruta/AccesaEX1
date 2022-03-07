package com.example.mentoringv1ex2.mapper;

import com.example.mentoringv1ex2.model.Device;
import com.example.mentoringv1ex2.dto.DeviceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    @Mappings({
           @Mapping(target = "user.id", source = "deviceDTO.user")
    })
    Device fromDTO(DeviceDTO deviceDTO);

    @Mappings({
            @Mapping(target = "user", source = "device.user.id")
    })
    DeviceDTO toDTO(Device device);

}
