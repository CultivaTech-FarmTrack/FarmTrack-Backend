package com.cultivatech.farmtrackbackend.subscription.domain.services.queryService;

import com.cultivatech.farmtrackbackend.subscription.domain.model.queries.GetSubscriptionByAccountIdQuery;
import com.cultivatech.farmtrackbackend.subscription.domain.model.aggregates.Subscription;

public interface ISubscriptionQueryService {
    Subscription handle(GetSubscriptionByAccountIdQuery getSubscriptionByAccountIdQuery);
}
