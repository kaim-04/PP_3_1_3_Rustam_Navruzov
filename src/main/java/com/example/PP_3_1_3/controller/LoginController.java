package com.example.PP_3_1_3.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("logout")
    public String logout(){
        return "redirect:/login";
    }

}
