package com.cultivatech.farmtrackbackend.ccm.interfaces.rest;

import com.cultivatech.farmtrackbackend.ccm.domain.model.commands.chat.CreateMessageCommand;
import com.cultivatech.farmtrackbackend.ccm.domain.model.entities.Message;
import com.cultivatech.farmtrackbackend.ccm.domain.model.queries.chat.GetMessageByContactIdQuery;
import com.cultivatech.farmtrackbackend.ccm.application.internal.message.MessageCommandService;
import com.cultivatech.farmtrackbackend.ccm.application.internal.message.MessageQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageCommandService messageCommandService;
    private final MessageQueryService messageQueryService;
    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createMessage(@RequestBody CreateMessageCommand createMessageCommand){
        this.messageCommandService.handle(createMessageCommand);
        return ResponseEntity.ok("Message Created!");
    }
    @CrossOrigin
    @GetMapping("/{contactId}")
    public ResponseEntity<?>getMessagesByContactId(@PathVariable("contactId") Long contactId){
        GetMessageByContactIdQuery getMessageByContactIdQuery=new GetMessageByContactIdQuery(contactId);
        List<Message> messages=this.messageQueryService.handle(getMessageByContactIdQuery);
        return ResponseEntity.ok(messages);
    }
}
