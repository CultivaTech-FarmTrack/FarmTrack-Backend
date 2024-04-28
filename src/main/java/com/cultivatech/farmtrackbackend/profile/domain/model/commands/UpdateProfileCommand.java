package com.cultivatech.farmtrackbackend.profile.domain.model.commands;

public record UpdateProfileCommand(Long accountId, String name,String description,String imageUrl,String location,Long planId) {
}
