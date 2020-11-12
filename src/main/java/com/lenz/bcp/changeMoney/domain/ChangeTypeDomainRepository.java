package com.lenz.bcp.changeMoney.domain;

import io.reactivex.Maybe;

public interface ChangeTypeDomainRepository {
    Maybe<ChangeTypeRespectDollarDomain> getChangeType(String type);
    void saveChangeType(String money, Double changeType);
}
