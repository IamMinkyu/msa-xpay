package com.xpay.money.adapter.out.persistence;

import com.xpay.common.PersistenceAdapter;
import com.xpay.money.application.port.out.IncreaseMoneyPort;
import com.xpay.money.domain.MemberMoney;
import com.xpay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {

  private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;
  private final SpringDataMemberMoneyRepository memberMoneyRepository;

  @Override
  public MemberMoneyJpaEntity increaseMoney(MemberMoney.MembershipId memberId, int increaseMoneyAmount) {
    MemberMoneyJpaEntity entity;
    try {
      List<MemberMoneyJpaEntity> entityList =  memberMoneyRepository.findByMembershipId(Long.parseLong(memberId.getMembershipId()));
      entity = entityList.get(0);

      entity.setBalance(entity.getBalance() + increaseMoneyAmount);
      return  memberMoneyRepository.save(entity);
    } catch (Exception e){
      entity = new MemberMoneyJpaEntity(
          Long.parseLong(memberId.getMembershipId()),
          increaseMoneyAmount, ""
      );
      entity = memberMoneyRepository.save(entity);
      return entity;
    }
  }

  @Override
  public MoneyChangingRequestJpaEntity createMoneyChangingRequest(
      MoneyChangingRequest.TargetMembershipId targetMembershipId,
      MoneyChangingRequest.MoneyChangingType moneyChangingType,
      MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
      MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus,
      MoneyChangingRequest.Uuid uuid) {
    return moneyChangingRequestRepository.save(
        new MoneyChangingRequestJpaEntity(
            targetMembershipId.getTargetMembershipId(),
            moneyChangingType.getMoneyChangingType(),
            changingMoneyAmount.getChangingMoneyAmount(),
            new Timestamp(System.currentTimeMillis()), // TODO: 2021-08-17 11:00:00
            moneyChangingStatus.getChangingMoneyStatus(),
            UUID.randomUUID()
        )
    );
  }

}
