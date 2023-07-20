package com.flat.management.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidLoginException extends Exception{
    private String msg;


}
