package com.example.cms.controller.exceptions;

public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException(Long id) {
        super("Could not find classroom " + id);
    }
}
