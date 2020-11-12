package com.lenz.bcp.changeMoney.application;


public final class ChangeMoneyResponse {
    private String originMoney;

    private String destinationMoney;

    private Double amount;

    private Double amountChanged;

    private Double changeType;

    public ChangeMoneyResponse(String originMoney, String destinationMoney, Double amount, Double amountChanged, Double changeType) {
        this.originMoney = originMoney;
        this.destinationMoney = destinationMoney;
        this.amount = amount;
        this.amountChanged = amountChanged;
        this.changeType = changeType;
    }

    public String originMoney() {
        return originMoney;
    }

    public String destinationMoney() {
        return destinationMoney;
    }

    public Double amount() {
        return amount;
    }

    public Double amountChanged() {
        return amountChanged;
    }

    public Double changeType() {
        return changeType;
    }
}
