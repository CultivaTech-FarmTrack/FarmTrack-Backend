package com.cultivatech.farmtrackbackend.devices.domain.model.commands;

public record setDeviceStatus(Long deviceId,boolean newStatus) {
}
