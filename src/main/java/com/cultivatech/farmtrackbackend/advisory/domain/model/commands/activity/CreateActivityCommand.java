package com.cultivatech.farmtrackbackend.advisory.domain.model.commands.activity;

public record CreateActivityCommand(Long projectId, String title,String description, String date) {

}
