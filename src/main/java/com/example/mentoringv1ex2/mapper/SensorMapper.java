package com.example.mentoringv1ex2.mapper;

import com.example.mentoringv1ex2.model.Sensor;
import com.example.mentoringv1ex2.dto.SensorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SensorMapper {


    @Mappings({
            @Mapping(target = "device.id", source = "sensorDTO.device")
    })
    Sensor fromDTO(SensorDTO sensorDTO);

    @Mappings({
            @Mapping(target = "device", source = "sensor.device.id")
    })
    SensorDTO toDTO(Sensor sensor);
}
