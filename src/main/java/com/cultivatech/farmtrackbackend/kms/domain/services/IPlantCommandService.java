package com.cultivatech.farmtrackbackend.kms.domain.services;

import com.cultivatech.farmtrackbackend.kms.domain.model.commands.CreatePlantCommand;
import com.cultivatech.farmtrackbackend.kms.domain.model.commands.DeletePlantCommand;
import com.cultivatech.farmtrackbackend.kms.domain.model.commands.GenerateSeedCommand;

public interface IPlantCommandService {
    String handle(GenerateSeedCommand generateSeedCommand);
    Long handle(CreatePlantCommand createPlantCommand);
    Long handle(DeletePlantCommand deletePlantCommand);

}
