package io.github.edsonzuchi.dolphin.infra.repository;

import io.github.edsonzuchi.dolphin.core.model.entity.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtorRepository extends JpaRepository<Debtor, Long> {
}
