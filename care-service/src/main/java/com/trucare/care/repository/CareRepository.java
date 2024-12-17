package com.trucare.care.repository;

import com.trucare.care.model.Care;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareRepository extends JpaRepository<Care, Long> {

    List<Care> findByMemberId(String memberId);  // Find cares by member ID
}

