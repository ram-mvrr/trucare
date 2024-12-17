package com.trucare.care.service;



import com.trucare.document.shared.care.CareDTO;

import java.util.List;

public interface CareService {

    // Create Care
    CareDTO createCare(CareDTO careDTO);

    // Get Care by ID
    CareDTO getCareById(Long id);

    // Get Cares by Member ID
    List<CareDTO> getCaresByMemberId(String memberId);

    // Get all Cares
    List<CareDTO> getAllCares();

    // Update Care
    CareDTO updateCare(Long id, CareDTO careDTO);

    // Delete Care
    void deleteCare(Long id);
}
