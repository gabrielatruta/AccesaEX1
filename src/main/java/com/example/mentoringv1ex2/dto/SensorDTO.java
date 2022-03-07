package com.example.mentoringv1ex2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorDTO {

    private Long id;
    private String description;
    private Long maxValue;
    private Long device;

}
