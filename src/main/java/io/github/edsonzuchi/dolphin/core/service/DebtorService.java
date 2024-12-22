package io.github.edsonzuchi.dolphin.core.service;

import io.github.edsonzuchi.dolphin.core.model.dto.DebtorDto;
import io.github.edsonzuchi.dolphin.core.model.entity.Debtor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DebtorService {

    Debtor saveDebtor(DebtorDto dto);
    List<Debtor> findAll();
}
