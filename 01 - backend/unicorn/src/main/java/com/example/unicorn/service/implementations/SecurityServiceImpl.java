package com.example.unicorn.service;

import com.example.unicorn.dao.UserAccountRepository;
import com.example.unicorn.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl extends SecurityService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void saveUser(UserAccount userAccount) {
        userAccount = encodeUserAccountPassword(userAccount);
        userAccountRepository.save(userAccount);
    }

    public String test() {
        return "Test";
    }

    private UserAccount encodeUserAccountPassword(UserAccount userAccount) {
        userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
        return userAccount;
    }
}
