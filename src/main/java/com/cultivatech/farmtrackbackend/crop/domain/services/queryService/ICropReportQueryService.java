package com.cultivatech.farmtrackbackend.crop.domain.services.queryService;

import com.cultivatech.farmtrackbackend.crop.domain.model.aggregates.CropReport;
import com.cultivatech.farmtrackbackend.crop.domain.model.queries.GetCropReportByIdQuery;
import com.cultivatech.farmtrackbackend.crop.domain.model.queries.GetCropReportsByCropIdQuery;

import java.util.List;

public interface ICropReportQueryService {

    CropReport handle(GetCropReportByIdQuery getCropReportByIdQuery);
    List<CropReport> handle (GetCropReportsByCropIdQuery getCropReportsByCropIdQuery);
}
