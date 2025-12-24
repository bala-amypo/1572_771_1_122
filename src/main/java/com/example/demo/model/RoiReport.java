package com.example.demo.model;

public class RoiReport {

    private Long influencerId;
    private Double roi;

    public RoiReport() {}

    public RoiReport(Long influencerId, Double roi) {
        this.influencerId = influencerId;
        this.roi = roi;
    }

    public Long getInfluencerId() { return influencerId; }
    public void setInfluencerId(Long influencerId) { this.influencerId = influencerId; }

    public Double getRoi() { return roi; }
    public void setRoi(Double roi) { this.roi = roi; }
}
