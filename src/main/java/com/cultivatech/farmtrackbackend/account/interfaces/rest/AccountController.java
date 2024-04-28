package com.cultivatech.farmtrackbackend.account.interfaces.rest;

import com.cultivatech.farmtrackbackend.profile.application.internal.ProfileCommandService;
import com.cultivatech.farmtrackbackend.profile.application.internal.SpecialistCommandService;
import com.cultivatech.farmtrackbackend.account.application.internal.AccountCommandService;
import com.cultivatech.farmtrackbackend.account.application.internal.QueryService.AccountQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AccountController {
    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;
    private final ProfileCommandService profileCommandService;
    private final SpecialistCommandService specialistCommandService;

    @CrossOrigin
    @PostMapping(value = "prueba")
    public String Welcome(){
        return "Welcome to agripure";
    }
}
