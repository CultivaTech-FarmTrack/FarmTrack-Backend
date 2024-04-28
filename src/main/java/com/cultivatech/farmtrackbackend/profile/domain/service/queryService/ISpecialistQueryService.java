package com.cultivatech.farmtrackbackend.profile.domain.service.queryService;

import com.cultivatech.farmtrackbackend.profile.domain.model.queries.specialist.GetSpecialistByAccountIdQuery;
import com.cultivatech.farmtrackbackend.profile.domain.model.aggregates.Specialist;

public interface ISpecialistQueryService {
    Specialist handle(GetSpecialistByAccountIdQuery getSpecialistByAccountIdQuery);

}
