package com.example.mentoringv1ex2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {

    private Long id;
    private String description;
    private String location;
    private Long maximumConsumption;
    private Long averageConsumption;
    private Long user;

}
