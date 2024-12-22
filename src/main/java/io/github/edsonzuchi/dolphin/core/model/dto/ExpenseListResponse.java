package io.github.edsonzuchi.dolphin.core.model.dto;

import io.github.edsonzuchi.dolphin.core.model.entity.Expense;

import java.util.List;

public record ExpenseListResponse(
    List<Expense> expenses,
    int page,
    int count,
    int totalCount,
    int totalPage
) {
}
