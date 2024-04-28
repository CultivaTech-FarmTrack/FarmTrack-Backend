package com.cultivatech.farmtrackbackend.crop.infrastructure;

import com.cultivatech.farmtrackbackend.crop.domain.model.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop,Long> {
    List<Crop> findCropByFarmerId(Long farmerId);
}
