package com.example.Risk.controller;

import com.example.Risk.model.RiskAppetite;
import com.example.Risk.repository.RiskAppetiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/risk-appetites")
public class RiskAppetiteController {

    @Autowired
    private RiskAppetiteRepository riskAppetiteRepository;

    @GetMapping
    public List<RiskAppetite> getAllRiskAppetites() {
        return riskAppetiteRepository.findAll();
    }

    @GetMapping("/{appetiteId}")
    public ResponseEntity<RiskAppetite> getRiskAppetiteById(@PathVariable Long appetiteId) {
        Optional<RiskAppetite> appetite = riskAppetiteRepository.findById(appetiteId);
        return appetite.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RiskAppetite> createRiskAppetite(@RequestBody RiskAppetite riskAppetite) {
        RiskAppetite savedAppetite = riskAppetiteRepository.save(riskAppetite);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppetite);
    }

    @PutMapping("/{appetiteId}")
    public ResponseEntity<RiskAppetite> updateRiskAppetite(@PathVariable Long appetiteId, @RequestBody RiskAppetite updatedAppetite) {
        return riskAppetiteRepository.findById(appetiteId).map(existingAppetite -> {
            updatedAppetite.setId(appetiteId);
            RiskAppetite savedAppetite = riskAppetiteRepository.save(updatedAppetite);
            return ResponseEntity.ok(savedAppetite);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{appetiteId}")
    public ResponseEntity<Void> deleteRiskAppetite(@PathVariable Long appetiteId) {
        riskAppetiteRepository.deleteById(appetiteId);
        return ResponseEntity.noContent().build();
    }
}
