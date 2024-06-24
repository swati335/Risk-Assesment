package com.example.Risk.controller;
import com.example.Risk.model.RiskAssessment;
import com.example.Risk.repository.RiskAssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/risk-assessments")
public class RiskAssessmentController {

    @Autowired
    private RiskAssessmentRepository riskAssessmentRepository;

    @GetMapping
    public List<RiskAssessment> getAllRiskAssessments() {
        return riskAssessmentRepository.findAll();
    }

    @GetMapping("/{assessmentId}")
    public ResponseEntity<RiskAssessment> getRiskAssessmentById(@PathVariable Long assessmentId) {
        Optional<RiskAssessment> assessment = riskAssessmentRepository.findById(assessmentId);
        return assessment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RiskAssessment> createRiskAssessment(@RequestBody RiskAssessment riskAssessment) {
        RiskAssessment savedAssessment = riskAssessmentRepository.save(riskAssessment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAssessment);
    }

    @PutMapping("/{assessmentId}")
    public ResponseEntity<RiskAssessment> updateRiskAssessment(@PathVariable Long assessmentId, @RequestBody RiskAssessment updatedAssessment) {
        return riskAssessmentRepository.findById(assessmentId).map(existingAssessment -> {
            updatedAssessment.setId(assessmentId);
            RiskAssessment savedAssessment = riskAssessmentRepository.save(updatedAssessment);
            return ResponseEntity.ok(savedAssessment);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{assessmentId}")
    public ResponseEntity<Void> deleteRiskAssessment(@PathVariable Long assessmentId) {
        riskAssessmentRepository.deleteById(assessmentId);
        return ResponseEntity.noContent().build();
    }
}
