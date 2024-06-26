package com.cultivatech.farmtrackbackend.profile.domain.service;

import com.cultivatech.farmtrackbackend.profile.domain.model.commands.CreateProfileCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.DeleteProfileCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.UpdateProfileCommand;

public interface IProfileCommandService {
    String handle(CreateProfileCommand createProfileCommand);

    String handle(UpdateProfileCommand updateProfileCommand);

    String handle(DeleteProfileCommand deleteProfileCommand);
}
