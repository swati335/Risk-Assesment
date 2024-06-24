package com.example.Risk.repository;

import com.example.Risk.model.Control;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ControlRepository extends JpaRepository<Control, Long> {
    List<Control> findByRiskId(Long riskId);
}