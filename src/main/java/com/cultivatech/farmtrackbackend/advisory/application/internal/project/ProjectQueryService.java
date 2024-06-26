package com.cultivatech.farmtrackbackend.advisory.application.internal.project;

import com.cultivatech.farmtrackbackend.advisory.domain.Services.project.IProjectQueryService;
import com.cultivatech.farmtrackbackend.advisory.domain.model.aggregates.Project;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.proyect.GetProjectByCropIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.proyect.GetProjectByIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.proyect.GetProjectsByFarmerIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.proyect.GetProjectsBySpecialistIdQuery;
import com.cultivatech.farmtrackbackend.advisory.infrastructure.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectQueryService implements IProjectQueryService {
    private final ProjectRepository projectRepository;
    @Override
    public Project handle(GetProjectByIdQuery getProjectByIdQuery) {
        Optional<Project> project =projectRepository.findById(getProjectByIdQuery.projectId());
        return project.get();
    }

    @Override
    public Project handle(GetProjectByCropIdQuery getProjectByCropIdQuery) {
        Optional<Project> project= Optional.ofNullable(projectRepository.findProjectByCropId(getProjectByCropIdQuery.cropId()));
        return project.get();
    }

    @Override
    public List<Project> handle(GetProjectsByFarmerIdQuery getProjectsByFarmerIdQuery) {
        List<Project> projects=projectRepository.findProjectsByFarmerId(getProjectsByFarmerIdQuery.farmerId());
        return projects;
    }

    @Override
    public List<Project> handle(GetProjectsBySpecialistIdQuery getProjectsBySpecialistIdQuery) {
        List<Project> projects=projectRepository.findProjectsBySpecialistId(getProjectsBySpecialistIdQuery.specialistId());
        return projects;
    }
}
