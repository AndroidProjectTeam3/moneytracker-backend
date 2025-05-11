package com.money_tracker.money_tracker;

import com.money_tracker.money_tracker.entity.User;
import com.money_tracker.money_tracker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDataConfig {

    @Bean
    public CommandLineRunner initUser(UserRepository userRepository) {
        return args -> {
//            userRepository.save(
//                    User.builder()
//                            .firebaseUid("test-uid-123")
//                            .name("홍길동")
//                            .age(25)
//                            .monthlyLimit(800000)
//                            .build()
//            );
        };
    }
}
