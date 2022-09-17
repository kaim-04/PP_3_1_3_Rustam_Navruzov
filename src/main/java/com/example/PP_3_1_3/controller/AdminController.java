package com.example.PP_3_1_3.controller;

import com.example.PP_3_1_3.model.User;
import com.example.PP_3_1_3.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String showUsers(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("user", userService.findByUsername(userDetails.getUsername()));
        model.addAttribute("roles", userService.findByUsername(userDetails.getUsername()).getRoles());
        model.addAttribute("users", userService.getAllUsers());
        return "users_info";
    }

    @PostMapping("/admin")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/users/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit_user";
    }

    @GetMapping("/admin/users/new")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users_info";
    }

    @PostMapping("/admin/users/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/users/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
