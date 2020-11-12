package com.lenz.bcp.changeMoney.domain;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface ChangeTypeDomainRepository {
    Maybe<ChangeTypeRespectDollarDomain> getChangeType(String type);
    void saveChangeType(String money, Double changeType);
    Observable<ChangeTypeRespectDollarDomain> getChangeTypes();
    void updateChangeType(String money, Double changeType);
}
