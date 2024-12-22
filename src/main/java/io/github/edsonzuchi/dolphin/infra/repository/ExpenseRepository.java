package io.github.edsonzuchi.dolphin.infra.repository;

import io.github.edsonzuchi.dolphin.core.model.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
