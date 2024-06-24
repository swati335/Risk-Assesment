package com.example.Risk.repository;

import com.example.Risk.model.RiskAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiskAssessmentRepository extends JpaRepository<RiskAssessment, Long> {
    List<RiskAssessment> findByRiskId(Long riskId);
}