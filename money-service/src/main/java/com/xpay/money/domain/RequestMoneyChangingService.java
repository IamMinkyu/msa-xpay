package com.xpay.money.domain;

import com.xpay.common.UseCase;
import com.xpay.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.xpay.money.adapter.out.persistence.MoneyChangingRequestMapper;
import com.xpay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.xpay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.xpay.money.application.port.out.IncreaseMoneyChangingRequestPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestMoneyChangingService implements IncreaseMoneyRequestUseCase {

  private final IncreaseMoneyChangingRequestPort increaseMoneyChangingRequestPort;
  private final MoneyChangingRequestMapper moneyChangingRequestMapper;
  @Override
  public MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command) {

    // command -> db
    MoneyChangingRequestJpaEntity entity = increaseMoneyChangingRequestPort.createMoneyChangingRequest(
        new MoneyChangingRequest.TargetMembershipId(command.getTargetMembershipId()),
        new MoneyChangingRequest.ChangingType(Integer.parseInt(ChangingType.INCREASING.toString())),
        new MoneyChangingRequest.ChangingMoneyAmount(command.getAmount()),
        new MoneyChangingRequest.ChangingMoneyStatus(Integer.parseInt(ChangingMoneyStatus.REQUESTED.toString())),
        new MoneyChangingRequest.UUID(UUID.randomUUID()),
        new Date());

    return moneyChangingRequestMapper.mapToDomainEntity(entity);
  }
}
