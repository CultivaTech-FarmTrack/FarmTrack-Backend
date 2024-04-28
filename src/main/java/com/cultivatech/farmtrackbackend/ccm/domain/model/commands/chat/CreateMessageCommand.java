package com.cultivatech.farmtrackbackend.ccm.domain.model.commands.chat;

public record CreateMessageCommand(Long contactId, Long authorId, String message, String hour) {

}
