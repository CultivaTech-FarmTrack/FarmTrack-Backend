package com.cultivatech.farmtrackbackend.crop.domain.services;

import com.cultivatech.farmtrackbackend.crop.domain.model.commands.CreateCropCommand;
import com.cultivatech.farmtrackbackend.crop.domain.model.commands.DeleteCropCommand;
import com.cultivatech.farmtrackbackend.crop.domain.model.commands.SetSpecialistToCropCommand;

public interface ICropCommandService {
    String handle(CreateCropCommand createCropCommand);

    String handle(SetSpecialistToCropCommand setSpecialistToCropCommand);
    String handle(DeleteCropCommand deleteCropCommand);



}
