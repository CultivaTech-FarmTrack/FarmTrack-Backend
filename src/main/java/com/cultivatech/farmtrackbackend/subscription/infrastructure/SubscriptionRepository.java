package com.cultivatech.farmtrackbackend.subscription.infrastructure;

import com.cultivatech.farmtrackbackend.subscription.domain.model.aggregates.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    Subscription findSubscriptionByAccountId(Long accountId);
}
