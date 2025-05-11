package com.money_tracker.money_tracker.service;

import com.money_tracker.money_tracker.entity.Expense;
import com.money_tracker.money_tracker.repository.ExpenseRepository;
import com.money_tracker.money_tracker.repository.UserRepository;
import com.money_tracker.money_tracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    public Expense addExpense(String firebaseUid, BigDecimal amount, String category, String description, LocalDate expenseDate, String emotion) {
        // firebaseUid로 userId 조회
        User user = userRepository.findByFirebaseUid(firebaseUid)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        String expenseMonth = expenseDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));

        Expense expense = Expense.builder()
                .userId(Math.toIntExact(user.getId()))
                .amount(amount)
                .category(category)
                .description(description)
                .expenseDate(expenseDate)
                .expenseMonth(expenseMonth)
                .emotion(emotion)
                .build();

        return expenseRepository.save(expense);
    }

    public List<Expense> findExpensesByFirebaseUid(String firebaseUid) {
        User user = userRepository.findByFirebaseUid(firebaseUid)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        return expenseRepository.findByUserId(Math.toIntExact(user.getId()));
    }
}
