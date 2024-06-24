package com.example.Risk.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

public class RiskAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long riskId;
    private Date date;
    private Integer score;
    private String comments;
    // Getters and Setters


    public Long getId() {
        return id;
    }

    public Long getRiskId() {
        return riskId;
    }

    public Date getDate() {
        return date;
    }

    public Integer getScore() {
        return score;
    }

    public String getComments() {
        return comments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
