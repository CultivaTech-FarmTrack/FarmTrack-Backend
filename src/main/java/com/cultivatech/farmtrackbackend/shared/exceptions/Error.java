package com.cultivatech.farmtrackbackend.shared.exceptions;

import lombok.Data;

@Data
public class Error {
    private String code;
    private String message;

}