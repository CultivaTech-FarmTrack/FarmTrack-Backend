package com.cultivatech.farmtrackbackend.advisory.infrastructure;

import com.cultivatech.farmtrackbackend.advisory.domain.model.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
    List<Contact> findContactsByFarmerId(Long farmerId);
    List<Contact> findContactsBySpecialistId(Long specialistId);
}
