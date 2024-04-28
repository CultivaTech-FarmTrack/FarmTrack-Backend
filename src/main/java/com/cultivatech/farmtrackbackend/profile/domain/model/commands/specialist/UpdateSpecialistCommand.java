package com.cultivatech.farmtrackbackend.profile.domain.model.commands.specialist;

public record UpdateSpecialistCommand(Long accountId, String expertise, String contactEmail, String areasOfFocus) {
}
