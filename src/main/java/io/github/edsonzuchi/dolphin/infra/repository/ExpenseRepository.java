package io.github.edsonzuchi.dolphin.infra.repository;

import io.github.edsonzuchi.dolphin.core.model.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    Page<Expense> findByDateBetween(LocalDate start, LocalDate end, Pageable pageable);
}
