package com.example.demo.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetMeasurementsResponse {
    private List<MeasurementDTO> measurements;
}