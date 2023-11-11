package ru.netology.SpringBoot_HW2_AuthorizationService.service;

import org.springframework.stereotype.Service;
import ru.netology.SpringBoot_HW2_AuthorizationService.exception.InvalidCredentials;
import ru.netology.SpringBoot_HW2_AuthorizationService.exception.UnauthorizedUser;
import ru.netology.SpringBoot_HW2_AuthorizationService.model.User;
import ru.netology.SpringBoot_HW2_AuthorizationService.repository.UserRepository;

import java.util.List;


@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
