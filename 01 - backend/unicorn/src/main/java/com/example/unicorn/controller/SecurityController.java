package com.example.unicorn.controller;

import com.example.unicorn.entity.UserAccount;
import com.example.unicorn.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @PostMapping("/register/save")
    public void saveUser(@RequestBody UserAccount userAccount) {
        securityService.saveUser(userAccount);
    }

    @GetMapping("/register/save")
    public String test() {
        return securityService.test();
    }
}
