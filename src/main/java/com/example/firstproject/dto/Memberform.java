package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {
    private String email;
    private String password;

//    public MemberForm(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }//Structure end