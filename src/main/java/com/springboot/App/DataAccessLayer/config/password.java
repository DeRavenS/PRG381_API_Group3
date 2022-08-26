package com.springboot.App.DataAccessLayer.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class password {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println(encoder.encode("test"));
    }


}
