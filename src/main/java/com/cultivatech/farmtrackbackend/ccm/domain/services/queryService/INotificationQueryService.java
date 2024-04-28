package com.cultivatech.farmtrackbackend.ccm.domain.services.queryService;

import com.cultivatech.farmtrackbackend.ccm.domain.model.aggregates.Notification;
import com.cultivatech.farmtrackbackend.ccm.domain.model.queries.GetNotificationsByToAccountId;

import java.util.List;

public interface INotificationQueryService {
    List<Notification> handle(GetNotificationsByToAccountId getNotificationsByToAccountId);
}
