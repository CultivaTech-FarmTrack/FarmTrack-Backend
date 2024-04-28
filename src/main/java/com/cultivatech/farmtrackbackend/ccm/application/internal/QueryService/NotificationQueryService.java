package com.cultivatech.farmtrackbackend.ccm.application.internal.QueryService;

import com.cultivatech.farmtrackbackend.ccm.domain.model.aggregates.Notification;
import com.cultivatech.farmtrackbackend.ccm.domain.model.queries.GetNotificationsByToAccountId;
import com.cultivatech.farmtrackbackend.ccm.domain.services.queryService.INotificationQueryService;
import com.cultivatech.farmtrackbackend.ccm.infrastructure.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationQueryService implements INotificationQueryService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<Notification> handle(GetNotificationsByToAccountId getNotificationsByToAccountId) {
        List<Notification> notifications = notificationRepository.findNotificationByToAccountId(getNotificationsByToAccountId.toAccountId());
        return notifications;
    }
}
