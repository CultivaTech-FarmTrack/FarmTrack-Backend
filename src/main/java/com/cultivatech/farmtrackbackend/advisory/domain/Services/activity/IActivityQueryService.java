package com.cultivatech.farmtrackbackend.advisory.domain.Services.activity;

import com.cultivatech.farmtrackbackend.advisory.domain.model.entities.Activity;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.activity.GetActivitiesByProjectId;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.activity.GetActivityByIdQuery;

import java.util.List;

public interface IActivityQueryService {
    Activity handle(GetActivityByIdQuery getActivityByIdQuery);
    List<Activity> handle(GetActivitiesByProjectId getActivitiesByProjectId);
}
