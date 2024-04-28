package com.cultivatech.farmtrackbackend.account.domain.model.commands;

public record CreateAccountCommand( String email,String password,String type) {
}
