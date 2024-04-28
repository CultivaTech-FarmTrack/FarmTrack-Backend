package com.cultivatech.farmtrackbackend.subscription.domain.services;

import com.cultivatech.farmtrackbackend.subscription.domain.model.commands.CreateSubscriptionCommand;
import com.cultivatech.farmtrackbackend.subscription.domain.model.commands.DeleteSubscriptionCommand;
import com.cultivatech.farmtrackbackend.subscription.domain.model.commands.UpdateSubscriptionCommand;

public interface ISubscriptionCommandService {
    String handle(CreateSubscriptionCommand createSubscriptionCommand);
    String handle(UpdateSubscriptionCommand updateSubscriptionCommand);
    String handle(DeleteSubscriptionCommand deleteSubscriptionCommand);
}
