package io.github.edsonzuchi.dolphin.core.model.dto;

import java.time.LocalDate;

public record ExpenseDto(
        Double value,
        String description,
        LocalDate date,
        Long originId,
        Long debtorId
) {
}
