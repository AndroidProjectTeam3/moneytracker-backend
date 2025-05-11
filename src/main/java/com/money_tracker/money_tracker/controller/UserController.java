package com.money_tracker.money_tracker.controller;

import com.money_tracker.money_tracker.entity.User;
import com.money_tracker.money_tracker.service.MonthlySettingsService;
import com.money_tracker.money_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MonthlySettingsService monthlySettingsService;

    @PostMapping
    public User registerUser(Authentication authentication,
                             @RequestParam String name,
                             @RequestParam Integer age,
                             @RequestParam Integer monthlyLimit) {

        String firebaseUid = (String) authentication.getPrincipal();

        // 1. users 테이블 등록/갱신
        User user = userService.registerUser(firebaseUid, name, age, monthlyLimit);

        // 2. monthly_settings 테이블에도 해당 월 기록 저장
        String settingMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        monthlySettingsService.saveOrUpdate(firebaseUid, settingMonth, monthlyLimit);

        return user;
    }

    @GetMapping("/me")
    public User getCurrentUser(Authentication authentication) {
        String firebaseUid = (String) authentication.getPrincipal();
        return userService.findByFirebaseUid(firebaseUid);
    }
}

