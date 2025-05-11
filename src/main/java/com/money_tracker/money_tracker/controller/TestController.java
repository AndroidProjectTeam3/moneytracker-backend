package com.money_tracker.money_tracker.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(Authentication authentication) {
        // Authentication 객체에 Firebase UID가 들어있음
        String uid = (String) authentication.getPrincipal();
        return "인증 성공! UID: " + uid;
    }
}
