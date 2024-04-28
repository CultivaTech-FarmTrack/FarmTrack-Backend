package com.cultivatech.farmtrackbackend.advisory.domain.Services.activity;

import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.activity.CompleteActivityCommand;
import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.activity.CreateActivityCommand;
import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.activity.DeleteActivityCommand;

public interface IActivityCommandService {
    String handle(CreateActivityCommand createActivityCommand);
    String handle(DeleteActivityCommand deleteActivityCommand);

    String handle(CompleteActivityCommand completeActivityCommand);
}
