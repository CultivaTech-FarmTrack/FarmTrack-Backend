package com.cultivatech.farmtrackbackend.crop.domain.model.commands;


public record AddCropReportCommand(Long cropId, String description, String image) {
}
