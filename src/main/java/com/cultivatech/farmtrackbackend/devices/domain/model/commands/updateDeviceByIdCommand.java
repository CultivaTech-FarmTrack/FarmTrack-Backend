package com.cultivatech.farmtrackbackend.devices.domain.model.commands;

public record updateDeviceByIdCommand(Long id,String name, String cropName, Long projectId, Boolean active, Boolean activeNotification) {
}
