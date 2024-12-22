package io.github.edsonzuchi.dolphin.core.service.impl;

import io.github.edsonzuchi.dolphin.core.exception.DebtorException;
import io.github.edsonzuchi.dolphin.core.exception.ExpenseException;
import io.github.edsonzuchi.dolphin.core.exception.OriginException;
import io.github.edsonzuchi.dolphin.core.model.dto.ExpenseDto;
import io.github.edsonzuchi.dolphin.core.model.dto.ExpenseListResponse;
import io.github.edsonzuchi.dolphin.core.model.entity.Expense;
import io.github.edsonzuchi.dolphin.core.service.ExpenseService;
import io.github.edsonzuchi.dolphin.infra.repository.DebtorRepository;
import io.github.edsonzuchi.dolphin.infra.repository.ExpenseRepository;
import io.github.edsonzuchi.dolphin.infra.repository.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private DebtorRepository debtorRepository;
    @Autowired
    private OriginRepository originRepository;

    @Override
    public Expense launchExpense(ExpenseDto dto) {
        if (dto.value() == null) {
            throw ExpenseException.VALUE_IS_NULL;
        }
        if (dto.description() == null || dto.description().isEmpty()) {
            throw ExpenseException.DESCRIPTION_IS_BLANK;
        }
        if (dto.date() == null) {
            throw ExpenseException.DATE_INVALID;
        }

        Expense expense = new Expense();
        expense.setDescription(dto.description());
        expense.setDate(dto.date());
        expense.setValue(dto.value());

        if (dto.debtorId() != null) {
            var debtor = debtorRepository.findById(dto.debtorId());
            if (debtor.isPresent()) {
                expense.setDebtor(debtor.get());
            }else{
                throw DebtorException.DEBTOR_NOT_FOUND;
            }
        }

        if (dto.originId() != null) {
            var origin = originRepository.findById(dto.originId());
            if (origin.isPresent()) {
                expense.setOrigin(origin.get());
            }else{
                throw OriginException.ORIGIN_NOT_FOUND;
            }
        }

        expenseRepository.save(expense);
        return expense;
    }

    @Override
    public ExpenseListResponse getExpenseList(YearMonth yearMonth, int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return null;
    }
}
