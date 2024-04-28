package com.cultivatech.farmtrackbackend.subscription.domain.model.commands;

public record UpdateSubscriptionCommand(Long accountId, Boolean active) {
}
