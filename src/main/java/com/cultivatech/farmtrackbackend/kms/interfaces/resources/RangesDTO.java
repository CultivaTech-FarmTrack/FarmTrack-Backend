package com.cultivatech.farmtrackbackend.kms.interfaces.resources;

import lombok.Data;

@Data
public class RangesDTO {
    private Double minTemperature;
    private Double maxTemperature;
    private Double minHumidity;
    private Double maxHumidity;
}
