package com.lenz.bcp.changeMoney.application;

import com.lenz.bcp.changeMoney.domain.ChangeTypeDomainRepository;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

@Service
public final class ChangeMoneyService {

    private ChangeTypeDomainRepository changeTypeDomainRepository;

    public ChangeMoneyService(ChangeTypeDomainRepository changeTypeDomainRepository) {
        this.changeTypeDomainRepository = changeTypeDomainRepository;
    }

    public Single<ChangeMoneyResponse> getChangeMoney(Double amount, String originMoney, String destinationMoney) {
        return Maybe.zip(
                changeTypeDomainRepository.getChangeType(originMoney)
                        .doOnSuccess(x-> System.out.println(x)).map(x -> x.changeType()),
                changeTypeDomainRepository.getChangeType(destinationMoney)
                        .doOnSuccess(x-> System.out.println(x)).map(x -> x.changeType()),
                (origin, destination) -> {
                    double changeType = (destination / origin);
                    return new ChangeMoneyResponse(originMoney, destinationMoney, amount,
                            changeType * amount, changeType);

                }
        ).toSingle();
    }

    public void saveNewType(String money, Double changeType) throws Exception {
        Boolean isEmpty = changeTypeDomainRepository.getChangeType(money).isEmpty().blockingGet();
        if(!isEmpty){
            changeTypeDomainRepository.updateChangeType(money, changeType);
        } else {
            changeTypeDomainRepository.saveChangeType(money, changeType);
        }

    }

    public Observable<ChangeTypeBean> getChangeTypes() {
        return changeTypeDomainRepository.getChangeTypes()
                .map(x->new ChangeTypeBean(x.moneyType(),x.changeType()));
    }
}
