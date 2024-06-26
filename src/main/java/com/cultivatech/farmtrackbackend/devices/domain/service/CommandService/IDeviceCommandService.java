package com.cultivatech.farmtrackbackend.devices.domain.service.CommandService;

import com.cultivatech.farmtrackbackend.devices.domain.model.commands.*;

public interface IDeviceCommandService {

    Long handle(updateDeviceByIdCommand updateDeviceByIdCommand);
    Long handle(createDeviceCommand command);
    String handle(setActiveNotification command);
    String handle (setDeviceStatus command);
    String handle(SetRealTimeDataCommand command);

    Long handle(SetTemperatureCommand command);
    Long handle(AssignDeviceToCropCommand command);
}
