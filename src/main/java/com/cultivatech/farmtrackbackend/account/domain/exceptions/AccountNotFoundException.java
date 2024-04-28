package com.cultivatech.farmtrackbackend.account.domain.exceptions;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String email){
        super("Account with email: "+email+" not found");
    }
}
