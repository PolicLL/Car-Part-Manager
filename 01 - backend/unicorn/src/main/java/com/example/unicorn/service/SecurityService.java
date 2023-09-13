package com.example.unicorn.service;

import com.example.unicorn.dao.UserAccountRepository;
import com.example.unicorn.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

public interface SecurityServiceInterface {

    void saveUser(UserAccount userAccount);

    String test();
}