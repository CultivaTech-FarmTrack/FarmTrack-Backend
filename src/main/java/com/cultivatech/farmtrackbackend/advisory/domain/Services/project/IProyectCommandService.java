package com.cultivatech.farmtrackbackend.advisory.domain.Services.project;

import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.project.AddDeviceProjectCommand;
import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.project.CreateProjectCommand;
import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.project.DeleteProjectCommand;
import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.project.StartProjectCommand;

public interface IProyectCommandService {
    String handle(AddDeviceProjectCommand addDeviceProjectCommand);
    String handle(CreateProjectCommand createProjectCommand);
    String handle(DeleteProjectCommand deleteProjectCommand);

    String handle(StartProjectCommand startProjectCommand);
}
