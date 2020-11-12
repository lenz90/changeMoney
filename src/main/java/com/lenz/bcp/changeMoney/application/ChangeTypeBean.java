package com.lenz.bcp.changeMoney.application;

public class ChangeTypeBean {
    private String money;

    private Double changeType;

    public ChangeTypeBean(String money, Double changeType) {
        this.money = money;
        this.changeType = changeType;
    }

    public String money() {
        return money;
    }

    public Double changeType() {
        return changeType;
    }
}
