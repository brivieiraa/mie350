package com.example.cms.controller.exceptions;

public class StudentGroupNotFoundException extends RuntimeException{
    public StudentGroupNotFoundException(Integer code) { super("Could not find student group " + code); }
}
