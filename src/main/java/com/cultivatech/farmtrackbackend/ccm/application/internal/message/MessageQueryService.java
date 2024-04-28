package com.cultivatech.farmtrackbackend.ccm.application.internal.message;

import com.cultivatech.farmtrackbackend.ccm.domain.model.entities.Message;
import com.cultivatech.farmtrackbackend.ccm.domain.model.queries.chat.GetMessageByContactIdQuery;
import com.cultivatech.farmtrackbackend.ccm.domain.services.message.IMessageQueryService;
import com.cultivatech.farmtrackbackend.ccm.infrastructure.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageQueryService implements IMessageQueryService {
    private final MessageRepository messageRepository;

    @Override
    public List<Message> handle(GetMessageByContactIdQuery getMessageByContactIdQuery){
        List<Message>messages=messageRepository.findMessageByContactId(getMessageByContactIdQuery.ContactId());
        return messages;
    }
}
