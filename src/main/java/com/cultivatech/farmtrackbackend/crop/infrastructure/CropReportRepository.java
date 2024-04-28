package com.cultivatech.farmtrackbackend.crop.infrastructure;

import com.cultivatech.farmtrackbackend.crop.domain.model.aggregates.CropReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropReportRepository extends JpaRepository<CropReport,Long> {
    List<CropReport> findByCropId(Long cropId);
}
