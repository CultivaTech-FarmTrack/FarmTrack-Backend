package com.cultivatech.farmtrackbackend.account.domain.services;

import com.cultivatech.farmtrackbackend.account.domain.model.commands.CreateAccountCommand;
import com.cultivatech.farmtrackbackend.account.domain.model.commands.DeleteAccountCommand;
import com.cultivatech.farmtrackbackend.account.domain.model.commands.LogInCommand;
import com.cultivatech.farmtrackbackend.account.infrastructure.dtos.AuthResponse;

public interface AccountCommandService {

    AuthResponse handle(CreateAccountCommand createAccountCommand);
    AuthResponse handle(LogInCommand logInCommand);

    String handle(DeleteAccountCommand deleteAccountCommand);
}
