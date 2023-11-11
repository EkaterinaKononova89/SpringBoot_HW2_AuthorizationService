package ru.netology.SpringBoot_HW2_AuthorizationService.exception;


public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}
