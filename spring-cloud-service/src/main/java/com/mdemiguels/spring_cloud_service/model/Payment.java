package com.mdemiguels.spring_cloud_service.model;

public class Payment {

    private String id;
    private double amount;

    public String getId() {
        return id;
    }

    public void setId(String paymentId) {
        this.id = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
