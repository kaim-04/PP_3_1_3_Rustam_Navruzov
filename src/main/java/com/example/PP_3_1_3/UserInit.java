package com.example.PP_3_1_3;

import com.example.PP_3_1_3.model.Role;
import com.example.PP_3_1_3.model.User;
import com.example.PP_3_1_3.service.UserService;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;

@Component
public class UserInit {

    private final UserService userService;

    public UserInit(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    private void userInit() {
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");

        Collection<Role> admins = new HashSet<>();
        Collection<Role> users = new HashSet<>();

        admins.add(adminRole);
        users.add(userRole);

        User admin = new User("admin", "admin", "admin@mail.ru", 25, "admin", admins);
        User user = new User("Rustam", "Navruzov", "rustam@mail.ru", 25, "user", users);

        userService.saveUser(admin);
        userService.saveUser(user);
    }

}
