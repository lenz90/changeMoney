package com.lenz.bcp.changeMoney.infrastructure.repository.h2;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@ToString
@Entity
@Table(name = "change_type_dollar")
public class ChangeTypeEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "money")
    private String money;
    @Column(name = "change_type")
    private Double changeType;

    public ChangeTypeEntity(String money, Double changeType) {
        this.id = UUID.randomUUID().toString();
        this.money = money;
        this.changeType = changeType;
    }

    public ChangeTypeEntity(String id, String money, Double changeType) {
        this.id = id;
        this.money = money;
        this.changeType = changeType;
    }

    public ChangeTypeEntity() {
    }

    public String id() {
        return id;
    }

    public String money() {
        return money;
    }

    public Double changeType() {
        return changeType;
    }
}
