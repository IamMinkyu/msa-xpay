package com.xpay.money.application.port.out;

import com.xpay.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.xpay.money.domain.MoneyChangingRequest;

import java.util.Date;

public interface IncreaseMoneyChangingRequestPort {

  MoneyChangingRequestJpaEntity createMoneyChangingRequest(
      MoneyChangingRequest.TargetMembershipId targetMembershipId,
      MoneyChangingRequest.ChangingType changingType,
      MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
      MoneyChangingRequest.ChangingMoneyStatus changingMoneyStatus,
      MoneyChangingRequest.UUID uuid,
      Date createdAt);
}
