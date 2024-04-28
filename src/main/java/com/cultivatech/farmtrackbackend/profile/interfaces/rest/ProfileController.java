package com.cultivatech.farmtrackbackend.profile.interfaces.rest;
import com.cultivatech.farmtrackbackend.profile.domain.model.aggregates.Profile;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.CreateProfileCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.DeleteProfileCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.UpdateProfileCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.specialist.DeleteSpecialistCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.commands.specialist.UpdateSpecialistCommand;
import com.cultivatech.farmtrackbackend.profile.domain.model.queries.GetProfileByAccountIdQuery;
import com.cultivatech.farmtrackbackend.profile.domain.model.queries.specialist.GetSpecialistByAccountIdQuery;
import com.cultivatech.farmtrackbackend.account.application.internal.AccountCommandService;
import com.cultivatech.farmtrackbackend.account.application.internal.QueryService.AccountQueryService;
import com.cultivatech.farmtrackbackend.account.domain.model.aggregates.Account;
import com.cultivatech.farmtrackbackend.account.domain.model.commands.DeleteAccountCommand;
import com.cultivatech.farmtrackbackend.account.domain.model.enums.AccountRol;
import com.cultivatech.farmtrackbackend.account.domain.model.queries.GetAccountByEmailQuery;
import com.cultivatech.farmtrackbackend.account.domain.model.queries.GetEmailAndTypeByAccountIdQuery;
import com.cultivatech.farmtrackbackend.account.domain.model.queries.GetSpecialistsQuery;
import com.cultivatech.farmtrackbackend.advisory.application.internal.contact.ContactCommandService;
import com.cultivatech.farmtrackbackend.advisory.application.internal.contact.ContactQueryService;
import com.cultivatech.farmtrackbackend.advisory.application.internal.project.ProjectCommandService;
import com.cultivatech.farmtrackbackend.advisory.application.internal.project.ProjectQueryService;
import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.contact.DeleteContactCommand;
import com.cultivatech.farmtrackbackend.advisory.domain.model.commands.project.DeleteProjectCommand;
import com.cultivatech.farmtrackbackend.advisory.domain.model.entities.Contact;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.contact.GetContactsByFarmerIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.contact.GetContactsBySpecialistIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.proyect.GetProjectsByFarmerIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.proyect.GetProjectsBySpecialistIdQuery;

import com.cultivatech.farmtrackbackend.advisory.domain.model.aggregates.Project;

import com.cultivatech.farmtrackbackend.profile.application.internal.ProfileCommandService;
import com.cultivatech.farmtrackbackend.profile.application.internal.QueryService.ProfileQueryService;
import com.cultivatech.farmtrackbackend.profile.application.internal.QueryService.SpecialistQueryService;
import com.cultivatech.farmtrackbackend.profile.application.internal.SpecialistCommandService;
import com.cultivatech.farmtrackbackend.profile.domain.model.aggregates.Specialist;
import com.cultivatech.farmtrackbackend.profile.interfaces.rest.dto.UpdateSpecialistProfile;
import com.cultivatech.farmtrackbackend.profile.interfaces.rest.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;
    private final AccountQueryService accountQueryService;
    private final SpecialistQueryService specialistQueryService;
    private final SpecialistCommandService specialistCommandService;
    private final AccountCommandService accountCommandService;
    private final ProjectCommandService projectCommandService;
    private final ProjectQueryService projectQueryService;
    private final ContactCommandService contactCommandService;
    private final ContactQueryService contactQueryService;
    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createProfile(@RequestBody CreateProfileCommand createProfileCommand){
        this.profileCommandService.handle(createProfileCommand);
        return ResponseEntity.ok("Profile created!!!");
    }
    @CrossOrigin
    @GetMapping("/getProfile/{accountId}")
    public ResponseEntity<?> getUserByAccountId(@PathVariable("accountId")Long accountId){
        GetProfileByAccountIdQuery getProfileByAccountIdQuery=new GetProfileByAccountIdQuery(accountId);
        GetEmailAndTypeByAccountIdQuery getEmailAndTypeByAccountIdQuery =new GetEmailAndTypeByAccountIdQuery(accountId);

        Profile profile=this.profileQueryService.handle(getProfileByAccountIdQuery);
        Account account=this.accountQueryService.handle(getEmailAndTypeByAccountIdQuery);

        if (profile!=null && account!=null){
            User user=User.builder()
                    .email(account.getEmail())
                    .name(profile.getName())
                    .description(profile.getDescription())
                    .imageUrl(profile.getImageUrl())
                    .location(profile.getLocation())
                    .type(account.getRol().toString())
                    .planId(profile.getPlanId())
                    .accountId(profile.getAccountId())
                    .build();

            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @GetMapping("/getProfileByEmail/{email}")
    public ResponseEntity<?> getUserByAccountEmail(@PathVariable("email")String email){
        GetAccountByEmailQuery getAccountByEmailQuery=new GetAccountByEmailQuery(email);
        Account account= this.accountQueryService.handle(getAccountByEmailQuery);

        GetProfileByAccountIdQuery getEmailAndTypeByAccountIdQuery=new GetProfileByAccountIdQuery(account.getId());
        Profile profile=this.profileQueryService.handle(getEmailAndTypeByAccountIdQuery);

        if (profile != null){
            User user=User.builder()
                    .email(account.getEmail())
                    .name(profile.getName())
                    .description(profile.getDescription())
                    .imageUrl(profile.getImageUrl())
                    .location(profile.getLocation())
                    .type(account.getRol().toString())
                    .planId(profile.getPlanId())
                    .accountId(profile.getAccountId())
                    .build();

            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @GetMapping("/getSpecialistInfoByAccountId/{accountId}")
    public ResponseEntity<?> getSpecialistInfoByAccountId(@PathVariable("accountId")Long accountId){
        GetSpecialistByAccountIdQuery getSpecialistByAccountIdQuery=new GetSpecialistByAccountIdQuery(accountId);
        Specialist specialist=this.specialistQueryService.handle(getSpecialistByAccountIdQuery);
        if (specialist!=null ){
            return ResponseEntity.ok(specialist);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @GetMapping("/getSpecialists")
    public ResponseEntity<?>getAllProfilesBySpecialistType(){
        GetSpecialistsQuery getSpecialistsQuery =new GetSpecialistsQuery(AccountRol.SPECIALIST);
        List<Account> accounts=this.accountQueryService.handle(getSpecialistsQuery);
        if (accounts != null) {
            List<User> users = new ArrayList<>();

            for (Account account : accounts) {
                GetProfileByAccountIdQuery getProfileByAccountIdQuery = new GetProfileByAccountIdQuery(account.getId());
                GetEmailAndTypeByAccountIdQuery getEmailAndTypeByAccountIdQuery = new GetEmailAndTypeByAccountIdQuery(account.getId());

                Profile profile = this.profileQueryService.handle(getProfileByAccountIdQuery);

                if (profile != null) {
                    User user = User.builder()
                            .email(account.getEmail())
                            .name(profile.getName())
                            .description(profile.getDescription())
                            .imageUrl(profile.getImageUrl())
                            .location(profile.getLocation())
                            .type(account.getRol().toString())
                            .planId(profile.getPlanId())
                            .accountId(profile.getAccountId())
                            .build();
                    users.add(user);
                }
            }

            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @PutMapping("/updateFarmer")
    public ResponseEntity<?> updateFarmerProfileByAccountId(@RequestBody UpdateProfileCommand updateProfileCommand){
        String message=this.profileCommandService.handle(updateProfileCommand);
        return ResponseEntity.ok(message);
    }
    @CrossOrigin
    @PutMapping("/updateSpecialist")
    public ResponseEntity<?> updateSpecialistProfileByAccountId(@RequestBody UpdateSpecialistProfile updateSpecialistProfile){
        UpdateProfileCommand updateProfileCommand=new UpdateProfileCommand(updateSpecialistProfile.getAccountId(),
                updateSpecialistProfile.getName(), updateSpecialistProfile.getDescription(),
                updateSpecialistProfile.getImageUrl(),updateSpecialistProfile.getLocation(),updateSpecialistProfile.getPlanId());
        UpdateSpecialistCommand updateSpecialistCommand=new UpdateSpecialistCommand(updateProfileCommand.accountId(), updateSpecialistProfile.getExpertise(), updateSpecialistProfile.getContactEmail(), updateSpecialistProfile.getAreasOfFocus());
        String messageSpecialist=this.specialistCommandService.handle(updateSpecialistCommand);
        String message=this.profileCommandService.handle(updateProfileCommand);
        return ResponseEntity.ok(message+messageSpecialist);
    }
    @CrossOrigin
    @DeleteMapping("/deleteProfile/{accountId}")
    public ResponseEntity<?> deleteProfileByAccountId(@PathVariable("accountId")Long accountId){

        GetProfileByAccountIdQuery getProfileByAccountIdQuery=new GetProfileByAccountIdQuery(accountId);

        Profile profile=this.profileQueryService.handle(getProfileByAccountIdQuery);
        if(!profile.getClass().toString().equals("SPECIALIST")){
            DeleteSpecialistCommand deleteSpecialistCommand=new DeleteSpecialistCommand(accountId);
            this.specialistCommandService.handle(deleteSpecialistCommand);
        }

        DeleteProfileCommand deleteProfileCommand=new DeleteProfileCommand(accountId);
        DeleteAccountCommand deleteAccountCommand=new DeleteAccountCommand(accountId);

        if(!profile.getClass().toString().equals("SPECIALIST")){

            GetContactsBySpecialistIdQuery getContactsBySpecialistIdQuery=new GetContactsBySpecialistIdQuery(accountId);
            List<Contact> contacts=contactQueryService.handle(getContactsBySpecialistIdQuery);
            if(contacts!=null){
                for (Contact contact : contacts) {
                    DeleteContactCommand deleteContactCommand=new DeleteContactCommand(contact.getId());
                    contactCommandService.handle(deleteContactCommand);
                }
            }

            GetProjectsByFarmerIdQuery getProjectsByFarmerIdQuery=new GetProjectsByFarmerIdQuery(accountId);
            List<Project> projects=projectQueryService.handle(getProjectsByFarmerIdQuery);
            if(projects!=null){
                for (Project project : projects) {
                    DeleteProjectCommand deleteProjectCommand = new DeleteProjectCommand(project.getId());
                    projectCommandService.handle(deleteProjectCommand);
                }
            }


        }
        if(!profile.getClass().toString().equals("FARMER")){
            GetContactsByFarmerIdQuery getContactsByFarmerIdQuery=new GetContactsByFarmerIdQuery(accountId);
            List<Contact> contacts=contactQueryService.handle(getContactsByFarmerIdQuery);
            if(contacts!=null){
                for (Contact contact : contacts) {
                    DeleteContactCommand deleteContactCommand=new DeleteContactCommand(contact.getId());
                    contactCommandService.handle(deleteContactCommand);
                }
            }

            GetProjectsBySpecialistIdQuery getProjectsBySpecialistIdQuery=new GetProjectsBySpecialistIdQuery(accountId);
            List<Project> projects=projectQueryService.handle(getProjectsBySpecialistIdQuery);
            if(projects!=null){
                for (Project project : projects) {
                    DeleteProjectCommand deleteProjectCommand = new DeleteProjectCommand(project.getId());
                    projectCommandService.handle(deleteProjectCommand);
                }
            }
        }

        String profileMessage=this.profileCommandService.handle(deleteProfileCommand);
        String accountMessage=this.accountCommandService.handle(deleteAccountCommand);
        return ResponseEntity.ok(profileMessage+accountMessage);
    }
}
