package com.cultivatech.farmtrackbackend.profile.infrastructure;

import com.cultivatech.farmtrackbackend.profile.domain.model.aggregates.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
    Specialist findSpecialistByAccountId(Long accountId);
}
