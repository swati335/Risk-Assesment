package com.example.Risk.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Control {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long riskId;
    private String description;
    private String effectiveness;
    // Getters and Setters


    public Long getId() {
        return id;
    }

    public Long getRiskId() {
        return riskId;
    }

    public String getDescription() {
        return description;
    }

    public String getEffectiveness() {
        return effectiveness;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEffectiveness(String effectiveness) {
        this.effectiveness = effectiveness;
    }
}
