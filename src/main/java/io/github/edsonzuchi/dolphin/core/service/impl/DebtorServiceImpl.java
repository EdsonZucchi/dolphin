package io.github.edsonzuchi.dolphin.core.service.impl;

import io.github.edsonzuchi.dolphin.core.exception.DebtorException;
import io.github.edsonzuchi.dolphin.core.model.dto.DebtorDto;
import io.github.edsonzuchi.dolphin.core.model.entity.Debtor;
import io.github.edsonzuchi.dolphin.core.service.DebtorService;
import io.github.edsonzuchi.dolphin.infra.repository.DebtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebtorServiceImpl implements DebtorService {

    @Autowired
    private DebtorRepository debtorRepository;

    @Override
    public Debtor saveDebtor(DebtorDto dto) {
        if (dto.name() == null || dto.name().isEmpty()) {
            throw DebtorException.NAME_IS_BLANK;
        }

        Debtor debtor = new Debtor();
        debtor.setName(dto.name());

        debtorRepository.save(debtor);

        return debtor;
    }

    @Override
    public List<Debtor> findAll() {
        return debtorRepository.findAll();
    }
}
