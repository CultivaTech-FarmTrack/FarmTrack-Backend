package com.cultivatech.farmtrackbackend.kms.infrastructure;

import com.cultivatech.farmtrackbackend.kms.domain.model.aggregates.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Long> {
}
