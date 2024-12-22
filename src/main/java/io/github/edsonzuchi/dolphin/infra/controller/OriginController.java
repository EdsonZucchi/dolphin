package io.github.edsonzuchi.dolphin.infra.controller;

import io.github.edsonzuchi.dolphin.core.exception.OriginException;
import io.github.edsonzuchi.dolphin.core.model.dto.OriginDto;
import io.github.edsonzuchi.dolphin.core.service.OriginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/origin")
@RequiredArgsConstructor
public class OriginController {

    private final OriginService originService;

    @PostMapping
    public ResponseEntity<Object> saveOrigin(@RequestBody OriginDto originDto) {
        try {
            return ResponseEntity.ok(originService.saveOrigin(originDto));
        }catch (OriginException oe){
            return ResponseEntity.unprocessableEntity().body(oe);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> getOrigins() {
        try {
            return ResponseEntity.ok(originService.findAll());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
