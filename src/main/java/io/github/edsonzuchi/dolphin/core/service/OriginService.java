package io.github.edsonzuchi.dolphin.core.service;

import io.github.edsonzuchi.dolphin.core.model.dto.OriginDto;
import io.github.edsonzuchi.dolphin.core.model.entity.Origin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OriginService {

    Origin saveOrigin(OriginDto dto);
    List<Origin> findAll();
}
