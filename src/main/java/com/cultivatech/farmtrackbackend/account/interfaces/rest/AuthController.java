package com.cultivatech.farmtrackbackend.account.interfaces.rest;

import com.cultivatech.farmtrackbackend.account.domain.model.aggregates.Account;
import com.cultivatech.farmtrackbackend.account.domain.model.commands.CreateAccountCommand;
import com.cultivatech.farmtrackbackend.account.domain.model.commands.LogInCommand;
import com.cultivatech.farmtrackbackend.account.domain.model.queries.GetAccountByEmailQuery;
import com.cultivatech.farmtrackbackend.account.interfaces.rest.dto.CreateSpecialistAccount;
import com.cultivatech.farmtrackbackend.account.interfaces.rest.dto.CreateUserAccount;
import com.cultivatech.farmtrackbackend.profile.application.internal.ProfileCommandService;
import com.cultivatech.farmtrackbackend.profile.application.internal.SpecialistCommandService;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.CreateProfileCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.specialist.CreateSpecialistCommand;
import com.cultivatech.farmtrackbackend.account.application.internal.AccountCommandService;
import com.cultivatech.farmtrackbackend.account.application.internal.QueryService.AccountQueryService;
import com.cultivatech.farmtrackbackend.account.infrastructure.dtos.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;
    private final ProfileCommandService profileCommandService;
    private final SpecialistCommandService specialistCommandService;

    @CrossOrigin
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> logIn(@RequestBody LogInCommand logInCommand){
        return ResponseEntity.ok(this.accountCommandService.handle(logInCommand));
    }

    @CrossOrigin
    @PostMapping(value="registerFarmer")
    public ResponseEntity<?> registerFarmer(@RequestBody CreateUserAccount createUserAccount){

        CreateAccountCommand createAccountCommand=new CreateAccountCommand(createUserAccount.getEmail(),createUserAccount.getPassword(),createUserAccount.getType());

        this.accountCommandService.handle(createAccountCommand);

        GetAccountByEmailQuery getAccountByEmailQuery=new GetAccountByEmailQuery(createAccountCommand.email());

        Account account=this.accountQueryService.handle(getAccountByEmailQuery);

        CreateProfileCommand createProfileCommand=new CreateProfileCommand(
                account.getId().longValue(),
                createUserAccount.getName(),
                createUserAccount.getDescription(),
                createUserAccount.getImageUrl(),
                createUserAccount.getLocation(),
                createUserAccount.getPlanId());
        String message=this.profileCommandService.handle(createProfileCommand);
        return ResponseEntity.ok(message);
    }

    @CrossOrigin
    @PostMapping(value="registerSpecialist")
    public ResponseEntity<?> registerSpecialist(@RequestBody CreateSpecialistAccount createSpecialistAccount){

        CreateAccountCommand createAccountCommand=new CreateAccountCommand(createSpecialistAccount.getEmail(),createSpecialistAccount.getPassword(),createSpecialistAccount.getType());

        this.accountCommandService.handle(createAccountCommand);

        GetAccountByEmailQuery getAccountByEmailQuery=new GetAccountByEmailQuery(createAccountCommand.email());

        Account account=this.accountQueryService.handle(getAccountByEmailQuery);

        CreateProfileCommand createProfileCommand=new CreateProfileCommand(
                account.getId().longValue(),
                createSpecialistAccount.getName(),
                createSpecialistAccount.getDescription(),
                createSpecialistAccount.getImageUrl(),
                createSpecialistAccount.getLocation(),
                createSpecialistAccount.getPlanId());
        CreateSpecialistCommand createSpecialistCommand=new CreateSpecialistCommand(
                account.getId().longValue(),
                createSpecialistAccount.getExpertise(),
                createSpecialistAccount.getContactEmail(),
                createSpecialistAccount.getAreasOfFocus());
        String specialistMessage=this.specialistCommandService.handle(createSpecialistCommand);
        String message=this.profileCommandService.handle(createProfileCommand);
        return ResponseEntity.ok(message+specialistMessage);
    }
}
