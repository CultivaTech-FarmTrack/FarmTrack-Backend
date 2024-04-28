package com.cultivatech.farmtrackbackend.advisory.domain.Services.contact;
import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.contact.CreateContactCommand;
import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.contact.DeleteContactCommand;
import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.contact.StartChatCommand;

public interface IContactCommandService {
    String handle(CreateContactCommand createContactCommand);

    String handle(DeleteContactCommand deleteContactCommand);
    String handle(StartChatCommand startChatCommand);
}
