package com.trucare.claims.repository;

import com.trucare.claims.model.Claim;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends ReactiveCrudRepository<Claim, Long> {
    // Additional query methods can be added as needed
}
