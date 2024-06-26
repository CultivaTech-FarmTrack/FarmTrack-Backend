package com.cultivatech.farmtrackbackend.advisory.application.internal.activity;

import com.cultivatech.farmtrackbackend.advisory.domain.Services.activity.IActivityQueryService;
import com.cultivatech.farmtrackbackend.advisory.domain.model.entities.Activity;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.activity.GetActivitiesByProjectId;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.activity.GetActivityByIdQuery;
import com.cultivatech.farmtrackbackend.advisory.infrastructure.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityQueryService implements IActivityQueryService {
    private final ActivityRepository activityRepository;

    @Override
    public Activity handle(GetActivityByIdQuery getActivityByIdQuery) {
        Optional<Activity> activity=activityRepository.findById(getActivityByIdQuery.activityId());
        if(activity.isPresent()){
            return activity.get();
        }
        else{
            return null;
        }
    }

    @Override
    public List<Activity> handle(GetActivitiesByProjectId getActivitiesByProjectId) {
        List<Activity> activities= activityRepository.findActivitiesByProjectId(getActivitiesByProjectId.projectId());
        return activities;
    }
}
