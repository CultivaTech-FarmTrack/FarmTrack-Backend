package com.cultivatech.farmtrackbackend.ccm.domain.services;

import com.cultivatech.farmtrackbackend.ccm.domain.model.commands.CreateNotificationCommand;
import com.cultivatech.farmtrackbackend.ccm.domain.model.commands.DeleteNotificationCommand;

public interface INotificationsCommandService {
    String handle(CreateNotificationCommand createNotificationCommand);
    String handle(DeleteNotificationCommand deleteNotificationCommand);

}
