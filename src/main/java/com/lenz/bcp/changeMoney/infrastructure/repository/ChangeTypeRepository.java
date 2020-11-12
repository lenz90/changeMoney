package com.lenz.bcp.changeMoney.infrastructure.repository;

import com.lenz.bcp.changeMoney.domain.ChangeTypeDomainRepository;
import com.lenz.bcp.changeMoney.domain.ChangeTypeRespectDollarDomain;
import com.lenz.bcp.changeMoney.infrastructure.repository.h2.ChangeTypeEntity;
import com.lenz.bcp.changeMoney.infrastructure.repository.h2.ChangeTypeH2Repository;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import org.springframework.stereotype.Service;

@Service
public class ChangeTypeRepository implements ChangeTypeDomainRepository {
    private ChangeTypeH2Repository repository;

    public ChangeTypeRepository(ChangeTypeH2Repository repository) {
        this.repository = repository;
    }

    @Override
    public Maybe<ChangeTypeRespectDollarDomain> getChangeType(String type) {
        return Observable.fromIterable(repository.findAll()).filter(x->x.money().equalsIgnoreCase(type.trim()))
                .map(x->new ChangeTypeRespectDollarDomain(x.money(), x.changeType())).firstElement();
    }

    @Override
    public void saveChangeType(String money, Double changeType) {
        repository.save(new ChangeTypeEntity(money, changeType));
    }
}
