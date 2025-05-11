package com.money_tracker.money_tracker.repository;

import com.money_tracker.money_tracker.entity.MonthlySettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonthlySettingsRepository extends JpaRepository<MonthlySettings, Integer> {
    Optional<MonthlySettings> findByFirebaseUidAndSettingMonth(String firebaseUid, String settingMonth);
}
