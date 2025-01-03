package com.trucare.care.controller;

import com.trucare.care.service.CareService;
import com.trucare.shared.care.CareDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cares")
public class CareController {

    @Autowired
    private CareService careService;

    @PostMapping
    public ResponseEntity<CareDTO> createCare(@RequestBody CareDTO careDTO) {
        return ResponseEntity.ok(careService.createCare(careDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CareDTO> getCareById(@PathVariable Long id) {
        return ResponseEntity.ok(careService.getCareById(id));
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<CareDTO>> getCaresByMemberId(@PathVariable String memberId) {
        return ResponseEntity.ok(careService.getCaresByMemberId(memberId));
    }

    @GetMapping
    public ResponseEntity<List<CareDTO>> getAllCares() {
        return ResponseEntity.ok(careService.getAllCares());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CareDTO> updateCare(@PathVariable Long id, @RequestBody CareDTO careDTO) {
        return ResponseEntity.ok(careService.updateCare(id, careDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCare(@PathVariable Long id) {
        careService.deleteCare(id);
        return ResponseEntity.noContent().build();
    }
}

