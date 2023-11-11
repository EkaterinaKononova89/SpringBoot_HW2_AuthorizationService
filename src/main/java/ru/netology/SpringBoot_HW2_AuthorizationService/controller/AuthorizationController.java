package ru.netology.SpringBoot_HW2_AuthorizationService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.SpringBoot_HW2_AuthorizationService.exception.InvalidCredentials;
import ru.netology.SpringBoot_HW2_AuthorizationService.exception.UnauthorizedUser;
import ru.netology.SpringBoot_HW2_AuthorizationService.model.User;
import ru.netology.SpringBoot_HW2_AuthorizationService.resolver.UserParam;
import ru.netology.SpringBoot_HW2_AuthorizationService.service.Authorities;
import ru.netology.SpringBoot_HW2_AuthorizationService.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }


    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @UserParam User user) { //почему не работает с @RequestParam
        return service.getAuthorities(user);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials ex) {
        return new ResponseEntity<>("User name or password is empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser ex) {
        return new ResponseEntity<>("Unknown user", HttpStatus.UNAUTHORIZED);
    }
}
