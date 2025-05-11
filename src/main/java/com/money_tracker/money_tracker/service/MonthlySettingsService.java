package com.money_tracker.money_tracker.service;

import com.money_tracker.money_tracker.entity.MonthlySettings;
import com.money_tracker.money_tracker.repository.MonthlySettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonthlySettingsService {

    @Autowired
    private MonthlySettingsRepository repository;

    public void saveOrUpdate(String firebaseUid, String settingMonth, int limit) {
        Optional<MonthlySettings> existing = repository.findByFirebaseUidAndSettingMonth(firebaseUid, settingMonth);

        MonthlySettings settings = existing.orElse(new MonthlySettings());
        settings.setFirebaseUid(firebaseUid);
        settings.setSettingMonth(settingMonth);
        settings.setMonthlyLimit(limit);
        repository.save(settings);
    }
}
