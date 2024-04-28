package com.cultivatech.farmtrackbackend.devices.domain.model.commands;

public record setActiveNotification(Long deviceId,boolean newStatus) {
}
