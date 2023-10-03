package com.xpay.money.adapter.out.persistence;

import com.xpay.common.PersistenceAdapter;
import com.xpay.money.application.port.out.IncreaseMoneyChangingRequestPort;
import com.xpay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyChangingRequestPort {

  private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;

  @Override
  public MoneyChangingRequestJpaEntity createMoneyChangingRequest(
      MoneyChangingRequest.TargetMembershipId targetMembershipId,
      MoneyChangingRequest.ChangingType changingType,
      MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
      MoneyChangingRequest.ChangingMoneyStatus changingMoneyStatus,
      MoneyChangingRequest.UUID uuid,
      Date createdAt) {

    return moneyChangingRequestRepository.save(
        new MoneyChangingRequestJpaEntity(
            targetMembershipId.getMembershipId(),
            changingType.getChangingType(),
            changingMoneyAmount.getChangingMoneyAmount(),
            changingMoneyStatus.getChangingMoneyStatus(),
            uuid.getUuid(),
            createdAt));
  }
}
