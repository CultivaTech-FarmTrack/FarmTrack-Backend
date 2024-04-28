package com.cultivatech.farmtrackbackend.profile.domain.service.queryService;

import com.cultivatech.farmtrackbackend.profile.domain.model.aggregates.Profile;
import com.cultivatech.farmtrackbackend.profile.domain.model.queries.GetProfileByAccountIdQuery;

public interface IProfileQueryService {

    Profile handle(GetProfileByAccountIdQuery getProfileByAccountIdQuery);

}
