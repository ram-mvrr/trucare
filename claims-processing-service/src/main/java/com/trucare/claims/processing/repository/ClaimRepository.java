package com.trucare.claims.processing.repository;

import com.trucare.claims.processing.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
