package io.github.edsonzuchi.dolphin.infra.controller;

import io.github.edsonzuchi.dolphin.core.exception.DebtorException;
import io.github.edsonzuchi.dolphin.core.model.dto.DebtorDto;
import io.github.edsonzuchi.dolphin.core.service.DebtorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/debtor")
@RequiredArgsConstructor
public class DebtorController {

    private final DebtorService debtorService;

    @PostMapping
    public ResponseEntity<Object> saveDebtor(@RequestBody DebtorDto debtorDto) {
        try {
            return ResponseEntity.ok(debtorService.saveDebtor(debtorDto));
        }catch (DebtorException de){
            return ResponseEntity.unprocessableEntity().body(de);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> getDebtors() {
        try {
            return ResponseEntity.ok(debtorService.findAll());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
