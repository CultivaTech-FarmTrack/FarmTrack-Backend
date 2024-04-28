package com.cultivatech.farmtrackbackend.crop.domain.services.queryService;

import com.cultivatech.farmtrackbackend.crop.domain.model.entities.Crop;
import com.cultivatech.farmtrackbackend.crop.domain.model.queries.GetCropByIdQuery;
import com.cultivatech.farmtrackbackend.crop.domain.model.queries.GetCropsByFarmerIdQuery;

import java.util.List;

public interface ICropQueryService {
    Crop handle(GetCropByIdQuery getCropByIdQuery);
    List<Crop> handle(GetCropsByFarmerIdQuery getCropsByFarmerIdQuery);
}
