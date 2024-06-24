package com.example.Risk.controller;

import com.example.Risk.model.Risk;
import com.example.Risk.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/risks")
public class RiskController {
    @Autowired
    private RiskRepository riskRepository;

    @GetMapping
    public List<Risk> getAllRisks() {
        return riskRepository.findAll();
    }

    @GetMapping("/{riskId}")
    public ResponseEntity<Risk> getRiskById(@PathVariable Long riskId) {
        Optional<Risk> risk = riskRepository.findById(riskId);
        return risk.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Risk> createRisk(@RequestBody Risk risk) {
        Risk savedRisk = riskRepository.save(risk);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRisk);
    }

    @PutMapping("/{riskId}")
    public ResponseEntity<Risk> updateRisk(@PathVariable Long riskId, @RequestBody Risk updatedRisk) {
        return riskRepository.findById(riskId).map(existingRisk -> {
            updatedRisk.setId(riskId);
            Risk savedRisk = riskRepository.save(updatedRisk);
            return ResponseEntity.ok(savedRisk);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{riskId}")
    public ResponseEntity<Void> deleteRisk(@PathVariable Long riskId) {
        riskRepository.deleteById(riskId);
        return ResponseEntity.noContent().build();
    }
}