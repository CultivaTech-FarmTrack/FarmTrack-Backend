package com.cultivatech.farmtrackbackend.kms.domain.services;

import com.cultivatech.farmtrackbackend.kms.domain.model.queries.GetTemperatureAndHumidityRangesByPlantIdQuery;
import com.cultivatech.farmtrackbackend.kms.domain.model.aggregates.Plant;
import com.cultivatech.farmtrackbackend.kms.domain.model.queries.GetPlantByIdQuery;
import com.cultivatech.farmtrackbackend.kms.interfaces.resources.RangesDTO;

import java.util.List;

public interface IPlantQueryService {
    Plant handle(GetPlantByIdQuery getPlantByIdQuery);
    RangesDTO handle(GetTemperatureAndHumidityRangesByPlantIdQuery query);
    List<Plant>handle();
}
