package com.xpay.money.application.port.out;

import com.xpay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.xpay.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.xpay.money.domain.MemberMoney;
import com.xpay.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {

  MemberMoneyJpaEntity increaseMoney(
      MemberMoney.MembershipId memberId,
      int increaseMoneyAmount
  );

  MoneyChangingRequestJpaEntity createMoneyChangingRequest(
      MoneyChangingRequest.TargetMembershipId targetMembershipId,
      MoneyChangingRequest.MoneyChangingType moneyChangingType,
      MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
      MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus,
      MoneyChangingRequest.Uuid uuid
  );
}
