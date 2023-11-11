package ru.netology.SpringBoot_HW2_AuthorizationService.exception;


public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
