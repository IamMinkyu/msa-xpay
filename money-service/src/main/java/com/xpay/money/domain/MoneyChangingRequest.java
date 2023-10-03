package com.xpay.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Date;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MoneyChangingRequest {

  private final long moneyChangingRequestId;
  //어떤 고객의 증액/감액을 요청 했는지?
  private final String targetMembershipId;
  private final ChangingType changingType;
  private final int changingMoneyAmount; //only won
  private final ChangingMoneyStatus changingMoneyStatus;

  private final UUID uuid;
  private final Date createdAt;

  public static MoneyChangingRequest generateMoneyChangingRequest(
      MoneyChangingRequestId moneyChangingRequestId,
      TargetMembershipId targetMembershipId,
      ChangingType changingType,
      ChangingMoneyAmount changingMoneyAmount,
      ChangingMoneyStatus changingMoneyStatus,
      UUID uuid,
      Date createdAt) {
    return new MoneyChangingRequest(
        moneyChangingRequestId.getMoneyChangingRequestId(),
        targetMembershipId.getMembershipId(),
        changingType,
        changingMoneyAmount.getChangingMoneyAmount(),
        changingMoneyStatus,
        uuid,
        createdAt
    );
  }

  @Value
  public static class MoneyChangingRequestId {
    private final long moneyChangingRequestId;
    public MoneyChangingRequestId(long id) {
      this.moneyChangingRequestId = id;
    }
  }

  @Value
  public static class TargetMembershipId {
    private final String membershipId;
    public TargetMembershipId(String id) {
      this.membershipId = id;
    }
  }
  @Value
  public static class ChangingType {
    private final int changingType;
    public ChangingType(int type) {
      this.changingType = type;
    }
  }
  @Value
  public static class ChangingMoneyAmount {
    private final int changingMoneyAmount;
    public ChangingMoneyAmount(int amount) {
      this.changingMoneyAmount = amount;
    }
  }
  @Value
  public static class ChangingMoneyStatus {
    private final int changingMoneyStatus;
    public ChangingMoneyStatus(int status) {
      this.changingMoneyStatus = status;
    }
  }
  @Value
  public static class UUID {
    private final java.util.UUID uuid;
    public UUID(java.util.UUID uuid) {
      this.uuid = uuid;
    }
  }
}
