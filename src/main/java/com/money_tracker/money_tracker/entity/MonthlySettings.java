package com.money_tracker.money_tracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "monthly_settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthlySettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firebaseUid;

    private String settingMonth; // 'yyyy-MM'

    private int monthlyLimit;

    private LocalDateTime createdAt = LocalDateTime.now();


}
