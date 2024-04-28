package com.cultivatech.farmtrackbackend.account.application.internal;

import com.cultivatech.farmtrackbackend.account.application.internal.jwt.Service.JwtService;
import com.cultivatech.farmtrackbackend.account.domain.model.aggregates.Account;
import com.cultivatech.farmtrackbackend.account.domain.model.commands.CreateAccountCommand;
import com.cultivatech.farmtrackbackend.account.domain.model.commands.DeleteAccountCommand;
import com.cultivatech.farmtrackbackend.account.domain.model.commands.LogInCommand;
import com.cultivatech.farmtrackbackend.account.domain.model.enums.AccountRol;
import com.cultivatech.farmtrackbackend.account.infrastructure.dtos.AuthResponse;
import com.cultivatech.farmtrackbackend.account.infrastructure.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountCommandService implements com.cultivatech.farmtrackbackend.account.domain.services.AccountCommandService {

    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthResponse handle(CreateAccountCommand createAccountCommand) {
        Account account=Account.builder()
                .email(createAccountCommand.email())
                .password(passwordEncoder.encode(createAccountCommand.password()) )
                .rol(AccountRol.valueOf(createAccountCommand.type()))
                .build();
        this.accountRepository.save(account);
        return AuthResponse.builder().token(jwtService.getToken(account)).build();
    }


    @Override
    public AuthResponse handle(LogInCommand logInCommand) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logInCommand.email(),logInCommand.password()));
        UserDetails account=accountRepository.findByEmail(logInCommand.email()).orElseThrow();
        String token=jwtService.getToken(account);
        return AuthResponse.builder().token(token).build();

    }

    @Override
    public String handle(DeleteAccountCommand deleteAccountCommand){
        Optional<Account> account=this.accountRepository.findById(deleteAccountCommand.accountId());
        if(account.isPresent()){
            this.accountRepository.deleteById(deleteAccountCommand.accountId());
            return "Account with Id "+deleteAccountCommand.accountId()+" was deleted";
        }else {
            return "Account with Id: "+deleteAccountCommand.accountId()+" doesn´t exist";
        }
    }
}
