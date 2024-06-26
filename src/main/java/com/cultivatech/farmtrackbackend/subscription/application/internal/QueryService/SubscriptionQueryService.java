package com.cultivatech.farmtrackbackend.subscription.application.internal.QueryService;

import com.cultivatech.farmtrackbackend.subscription.domain.model.aggregates.Subscription;
import com.cultivatech.farmtrackbackend.subscription.domain.model.queries.GetSubscriptionByAccountIdQuery;
import com.cultivatech.farmtrackbackend.subscription.domain.services.queryService.ISubscriptionQueryService;
import com.cultivatech.farmtrackbackend.subscription.infrastructure.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionQueryService implements ISubscriptionQueryService {
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription handle(GetSubscriptionByAccountIdQuery getSubscriptionByAccountIdQuery) {
        Optional<Subscription> subscription=Optional.ofNullable(subscriptionRepository.findSubscriptionByAccountId(getSubscriptionByAccountIdQuery.accountId()));
        if(subscription.isPresent()){
            return subscription.get();
        }else {
            return null;
        }
    }
}
