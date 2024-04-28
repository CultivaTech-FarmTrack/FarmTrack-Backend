package com.cultivatech.farmtrackbackend.ccm.domain.services.message;

import com.cultivatech.farmtrackbackend.ccm.domain.model.entities.Message;
import com.cultivatech.farmtrackbackend.ccm.domain.model.queries.chat.GetMessageByContactIdQuery;

import java.util.List;


public interface IMessageQueryService {
    List<Message> handle (GetMessageByContactIdQuery getMessageByContactIdQuery);
}
