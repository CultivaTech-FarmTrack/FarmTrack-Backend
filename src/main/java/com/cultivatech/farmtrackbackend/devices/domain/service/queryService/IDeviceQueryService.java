package com.cultivatech.farmtrackbackend.devices.domain.service.queryService;

import com.cultivatech.farmtrackbackend.devices.domain.model.aggregate.Device;
import com.cultivatech.farmtrackbackend.devices.domain.model.queries.*;
import com.cultivatech.farmtrackbackend.devices.interfaces.DTOs.TemperatureAndHumidity;

import java.util.List;

public interface IDeviceQueryService {

    List<Device> handle(GetDevicesByCropIdQuery getDevicesByCropIdQuery);

    Device handle(getTemperatureQuery query);
    Device handle(GetDeviceByIdQuery query);


    List<TemperatureAndHumidity> handle(GetTemperaturesAndHumidityByCropIdQuery query);

    List<Device> handle(GetDevicesByFarmerIdQuery getDevicesByFarmerIdQuery);

}
