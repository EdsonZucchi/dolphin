package io.github.edsonzuchi.dolphin.infra.repository;

import io.github.edsonzuchi.dolphin.core.model.entity.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginRepository extends JpaRepository<Origin, Long> {
}
