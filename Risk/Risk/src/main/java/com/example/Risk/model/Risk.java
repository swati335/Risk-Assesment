package com.example.Risk.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Risk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String type;
    private String severity;
    private String status;
    private String mitigationPlan;

    public Risk(Long id, String description, String type, String severity, String status, String mitigationPlan) {
      this.id=id;
    this.description=description;
    this.type=type;
    this.severity=severity;
    this.status=status;
    this.mitigationPlan=mitigationPlan;
  }
//    Getters and Setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMitigationPlan(String mitigationPlan) {
        this.mitigationPlan = mitigationPlan;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getMitigationPlan() {
        return mitigationPlan;
    }

}