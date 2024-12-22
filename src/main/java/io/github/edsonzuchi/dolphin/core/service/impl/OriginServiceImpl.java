package io.github.edsonzuchi.dolphin.core.service.impl;

import io.github.edsonzuchi.dolphin.core.exception.OriginException;
import io.github.edsonzuchi.dolphin.core.model.dto.OriginDto;
import io.github.edsonzuchi.dolphin.core.model.entity.Origin;
import io.github.edsonzuchi.dolphin.core.service.OriginService;
import io.github.edsonzuchi.dolphin.infra.repository.OriginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OriginServiceImpl implements OriginService {

    private final OriginRepository originRepository;

    @Override
    public Origin saveOrigin(OriginDto dto) {
        if (dto.name() == null || dto.name().isEmpty()) {
            throw OriginException.NAME_IS_BLANK;
        }

        Origin origin = new Origin();
        origin.setName(dto.name());

        originRepository.save(origin);

        return origin;
    }

    @Override
    public List<Origin> findAll() {
        return originRepository.findAll();
    }
}
