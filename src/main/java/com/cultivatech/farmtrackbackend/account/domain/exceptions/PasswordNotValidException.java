package com.cultivatech.farmtrackbackend.account.domain.exceptions;

public class PasswordNotValidException extends RuntimeException{
    public PasswordNotValidException(String email){
        super("Invalid Password por the account with email: "+email);
    }
}
