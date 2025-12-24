package com.example.demo.model;

public class RoiReport {
    private Long campaignId;
    private double roi;

    public RoiReport() {}

    public RoiReport(Long campaignId, double roi) {
        this.campaignId = campaignId;
        this.roi = roi;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }
}
