package com.money_tracker.money_tracker.controller;

import com.money_tracker.money_tracker.entity.Expense;
import com.money_tracker.money_tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense addExpense(
            Authentication authentication,
            @RequestParam BigDecimal amount,
            @RequestParam String category,
            @RequestParam(required = false) String description,
            @RequestParam String expenseDate,   // yyyy-MM-dd 형식
            @RequestParam(required = false) String emotion
    ) {
        String firebaseUid = (String) authentication.getPrincipal();

        LocalDate parsedExpenseDate = LocalDate.parse(expenseDate);  // 문자열을 LocalDate로 변환

        return expenseService.addExpense(firebaseUid, amount, category, description, parsedExpenseDate, emotion);
    }

    @GetMapping
    public List<Expense> getExpenses(Authentication authentication) {
        String firebaseUid = (String) authentication.getPrincipal();
        return expenseService.findExpensesByFirebaseUid(firebaseUid);
    }
}
