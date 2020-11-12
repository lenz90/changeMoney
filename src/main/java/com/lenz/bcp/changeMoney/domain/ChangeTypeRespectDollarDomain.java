package com.lenz.bcp.changeMoney.domain;

import lombok.ToString;

@ToString
public class ChangeTypeRespectDollarDomain {
    private String moneyType;
    private Double changeType;

    public ChangeTypeRespectDollarDomain(String moneyType, Double changeType) {
        this.moneyType = moneyType;
        this.changeType = changeType;
    }

    public String moneyType() {
        return moneyType;
    }

    public Double changeType() {
        return changeType;
    }
}
