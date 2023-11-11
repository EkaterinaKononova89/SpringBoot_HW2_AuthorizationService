package ru.netology.SpringBoot_HW2_AuthorizationService.repository;

import org.springframework.stereotype.Repository;
import ru.netology.SpringBoot_HW2_AuthorizationService.model.User;
import ru.netology.SpringBoot_HW2_AuthorizationService.service.Authorities;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class UserRepository {

    private final ConcurrentHashMap<User, List<Authorities>> repository = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(User user) {
        if (repository.containsKey(user)) {
            return repository.get(user);
        }
        return null;
    }
}