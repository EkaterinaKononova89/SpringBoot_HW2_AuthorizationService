package ru.netology.SpringBoot_HW2_AuthorizationService.model;


import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Valid
public class User {
    @NotBlank
    @Size(min = 2, max = 10)
    private String name;
    @NotBlank
    @Size(min = 6)
    private String password;


//    public User() { } // нужен ли пустой конструктор для работы с Jackson?

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    @Override
    public boolean equals(Object obj) {
        User o = (User) obj;
        return name.equals(o.name) && password.equals(o.password);
    }
}
