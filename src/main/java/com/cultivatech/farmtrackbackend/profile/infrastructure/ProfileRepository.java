package com.cultivatech.farmtrackbackend.profile.infrastructure;

import com.cultivatech.farmtrackbackend.profile.domain.model.aggregates.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findProfileByAccountId(Long accountId);
}
