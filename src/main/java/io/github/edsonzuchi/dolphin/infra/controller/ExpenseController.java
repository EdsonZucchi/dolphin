package io.github.edsonzuchi.dolphin.infra.controller;

import io.github.edsonzuchi.dolphin.core.exception.ExpenseException;
import io.github.edsonzuchi.dolphin.core.model.dto.ExpenseDto;
import io.github.edsonzuchi.dolphin.core.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.time.YearMonth;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Object> launchExpense(ExpenseDto expenseDto) {
        try {
            return ResponseEntity.ok(expenseService.launchExpense(expenseDto));
        }catch (ExpenseException ee){
            return ResponseEntity.unprocessableEntity().body(ee.getMessage());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> getExpenses(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam YearMonth yearMonth
    ) {
        try {
            return ResponseEntity.ok(expenseService.getExpenseList(yearMonth, page, size));
        } catch (ExpenseException ee){
            return ResponseEntity.unprocessableEntity().body(ee.getMessage());
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
