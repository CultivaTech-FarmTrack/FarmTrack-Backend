package com.cultivatech.farmtrackbackend.devices.domain.model.commands;

public record SetRealTimeDataCommand(Long deviceId,boolean newStatus) {
}
