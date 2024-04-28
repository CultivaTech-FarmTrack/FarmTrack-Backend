package com.cultivatech.farmtrackbackend.profile.domain.service;

import com.cultivatech.farmtrackbackend.profile.domain.model.commands.specialist.CreateSpecialistCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.specialist.DeleteSpecialistCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.specialist.UpdateSpecialistCommand;

public interface ISpecialistCommandService {
    String handle(CreateSpecialistCommand createSpecialistCommand);
    String handle(DeleteSpecialistCommand deleteSpecialistCommand);
    String handle(UpdateSpecialistCommand updateSpecialistCommand);
}
