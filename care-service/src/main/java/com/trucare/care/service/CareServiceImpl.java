package com.trucare.care.service;


import com.trucare.care.mapper.CareMapper;
import com.trucare.care.model.Care;
import com.trucare.care.repository.CareRepository;
import com.trucare.shared.care.CareDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CareServiceImpl implements CareService {

    @Autowired
    private CareRepository careRepository;

    @Autowired
    private CareMapper careMapper;

    @Override
    public CareDTO createCare(CareDTO careDTO) {
        Care care = careMapper.careDTOToCare(careDTO);
        care = careRepository.save(care);
        return careMapper.careToCareDTO(care);
    }

    @Override
    public CareDTO getCareById(Long id) {
        Care care = careRepository.findById(id).orElseThrow(() -> new RuntimeException("Care plan not found"));
        return careMapper.careToCareDTO(care);
    }

    @Override
    public List<CareDTO> getCaresByMemberId(String memberId) {
        List<Care> cares = careRepository.findByMemberId(memberId);
        return cares.stream()
                .map(careMapper::careToCareDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CareDTO> getAllCares() {
        List<Care> cares = careRepository.findAll();
        return cares.stream()
                .map(careMapper::careToCareDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CareDTO updateCare(Long id, CareDTO careDTO) {
        Care care = careRepository.findById(id).orElseThrow(() -> new RuntimeException("Care plan not found"));
        care.setMemberId(careDTO.getMemberId());
        care.setDiagnosis(careDTO.getDiagnosis());
        care.setCareProviderId(careDTO.getCareProviderId());
        care.setStartDate(careDTO.getStartDate());
        care.setEndDate(careDTO.getEndDate());
        care.setStatus(careDTO.getStatus());
        care = careRepository.save(care);
        return careMapper.careToCareDTO(care);
    }

    @Override
    public void deleteCare(Long id) {
        careRepository.deleteById(id);
    }
}
