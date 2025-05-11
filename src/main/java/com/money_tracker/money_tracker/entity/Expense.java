package com.money_tracker.money_tracker.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer userId;

    private BigDecimal amount;

    private String category;

    private String description;

    private LocalDate expenseDate;

    private String expenseMonth;

    private String emotion;
}
