package io.github.edsonzuchi.dolphin.core.service;

import io.github.edsonzuchi.dolphin.core.model.dto.ExpenseDto;
import io.github.edsonzuchi.dolphin.core.model.dto.ExpenseListResponse;
import io.github.edsonzuchi.dolphin.core.model.entity.Expense;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

@Service
public interface ExpenseService {

    Expense launchExpense(ExpenseDto dto);
    ExpenseListResponse getExpenseList(YearMonth yearMonth, int count, int page);

}
