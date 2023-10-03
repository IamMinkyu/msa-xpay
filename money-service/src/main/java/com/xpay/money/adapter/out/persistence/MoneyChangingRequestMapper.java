package com.xpay.money.adapter.out.persistence;


import com.xpay.money.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingRequestMapper {
  public MoneyChangingRequest mapToDomainEntity(MoneyChangingRequestJpaEntity entity) {
    return MoneyChangingRequest.generateMoneyChangingRequest(
        new MoneyChangingRequest.MoneyChangingRequestId(entity.getMoneyChangingRequestId()),
        new MoneyChangingRequest.TargetMembershipId(entity.getTargetMembershipId()),
        new MoneyChangingRequest.ChangingType(entity.getChangingStatus()),
        new MoneyChangingRequest.ChangingMoneyAmount(entity.getMoneyAmount()),
        new MoneyChangingRequest.ChangingMoneyStatus(entity.getChangingStatus()),
        new MoneyChangingRequest.UUID(entity.getUuid()),
        entity.getTimestamp());
  }
}
