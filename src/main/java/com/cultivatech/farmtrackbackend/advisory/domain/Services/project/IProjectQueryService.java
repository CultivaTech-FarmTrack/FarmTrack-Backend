package com.cultivatech.farmtrackbackend.advisory.domain.Services.project;

import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.proyect.GetProjectByCropIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.proyect.GetProjectByIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.proyect.GetProjectsByFarmerIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.proyect.GetProjectsBySpecialistIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.aggregates.Project;

import java.util.List;

public interface IProjectQueryService {
    Project handle(GetProjectByIdQuery getProjectByIdQuery);

    Project handle(GetProjectByCropIdQuery getProjectByCropIdQuery);
    List<Project> handle(GetProjectsByFarmerIdQuery getProjectsByFarmerIdQuery);

    List<Project> handle(GetProjectsBySpecialistIdQuery getProjectsBySpecialistIdQuery);
}
