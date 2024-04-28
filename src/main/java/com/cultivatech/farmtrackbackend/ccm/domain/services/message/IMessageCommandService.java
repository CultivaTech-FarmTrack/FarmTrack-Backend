package com.cultivatech.farmtrackbackend.ccm.domain.services.message;


import com.cultivatech.farmtrackbackend.ccm.domain.model.commands.chat.CreateMessageCommand;

public interface IMessageCommandService {
    String handle (CreateMessageCommand createMessageCommand);
}
