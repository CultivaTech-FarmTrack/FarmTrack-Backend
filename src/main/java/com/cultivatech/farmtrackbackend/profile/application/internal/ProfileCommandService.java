package com.cultivatech.farmtrackbackend.profile.application.internal;
import com.cultivatech.farmtrackbackend.profile.domain.model.aggregates.Profile;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.CreateProfileCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.DeleteProfileCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.UpdateProfileCommand;
import com.cultivatech.farmtrackbackend.profile.domain.service.IProfileCommandService;
import com.cultivatech.farmtrackbackend.profile.infrastructure.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProfileCommandService implements IProfileCommandService {
    private final ProfileRepository profileRepository;

    @Override
    public String handle(CreateProfileCommand createProfileCommand){
        Profile newProfile=Profile.builder()
                .accountId(createProfileCommand.accountId())
                .name(createProfileCommand.name())
                .description(createProfileCommand.description())
                .imageUrl(createProfileCommand.imageUrl())
                .location(createProfileCommand.location())
                .planId(createProfileCommand.planId())
                .build();
        if(profileRepository.save(newProfile)!=null){
            return "PROFILE CREATED!!";
        }else {
            return "CANT REGISTER YOUR PROFILE";
        }
    }

    @Override
    public String handle(UpdateProfileCommand updateProfileCommand){
        Optional<Profile> profile= Optional.ofNullable(profileRepository.findProfileByAccountId(updateProfileCommand.accountId()));
        if(profile.isPresent()){
            profile.get().setName(updateProfileCommand.name());
            profile.get().setDescription(updateProfileCommand.description());
            profile.get().setImageUrl(updateProfileCommand.imageUrl());
            profile.get().setLocation(updateProfileCommand.location());
            profile.get().setPlanId(updateProfileCommand.planId());
            profileRepository.save(profile.get());
            return "Profile updated!";
        }
        else {
            return "Profile with the given id doesn't exist";
        }
    }

    @Override
    public String handle(DeleteProfileCommand deleteProfileCommand){
        Optional<Profile> profile = Optional.ofNullable(profileRepository.findProfileByAccountId(deleteProfileCommand.accountId()));
        if(profile.isPresent()){
            profileRepository.deleteById(profile.get().getId());
            return "Profile with Id "+deleteProfileCommand.accountId()+" was deleted";
        }else {
            return "Profile with Id: "+deleteProfileCommand.accountId()+" doesn´t exist";
        }
    }
}
