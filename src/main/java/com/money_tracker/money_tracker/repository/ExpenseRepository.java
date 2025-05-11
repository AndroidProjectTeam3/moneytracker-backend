package com.money_tracker.money_tracker.repository;

import com.money_tracker.money_tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUserId(Integer userId); // 사용자별 조회용
}
