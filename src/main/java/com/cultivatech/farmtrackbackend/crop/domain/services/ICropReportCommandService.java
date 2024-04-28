package com.cultivatech.farmtrackbackend.crop.domain.services;

import com.cultivatech.farmtrackbackend.crop.domain.model.commands.AddCropReportCommand;
import com.cultivatech.farmtrackbackend.crop.domain.model.commands.DeleteCropReportCommand;

import java.io.IOException;

public interface ICropReportCommandService {
    String handle(AddCropReportCommand addCropReportCommand) throws IOException;
    String handle(DeleteCropReportCommand deleteCropReportCommand);
}
