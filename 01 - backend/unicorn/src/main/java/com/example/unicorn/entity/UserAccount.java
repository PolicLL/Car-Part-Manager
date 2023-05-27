package com.example.unicorn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user_accounts")
@NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "user_id")
    private long userId;

    @Column(name = "username")
    private String username ;

    private String email ;

    private String password ;

    private boolean enabled = true;
}