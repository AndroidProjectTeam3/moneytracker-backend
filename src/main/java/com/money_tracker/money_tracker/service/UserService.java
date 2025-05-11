package com.money_tracker.money_tracker.service;

import com.money_tracker.money_tracker.entity.User;
import com.money_tracker.money_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String firebaseUid, String name, Integer age, Integer monthlyLimit) {
        Optional<User> existingUser = userRepository.findByFirebaseUid(firebaseUid);

        if (existingUser.isPresent()) {
            return existingUser.get(); // 이미 존재하면 기존 사용자 반환
        }

        User newUser = User.builder()
                .firebaseUid(firebaseUid)
                .name(name)
                .age(age)
                .monthlyLimit(monthlyLimit)
                .build();

        return userRepository.save(newUser);
    }

    public User findByFirebaseUid(String firebaseUid) {
        return userRepository.findByFirebaseUid(firebaseUid)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
    }
}
