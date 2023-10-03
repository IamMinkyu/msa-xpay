package com.xpay.money.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "money_changing_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingRequestJpaEntity {

  @Id
  @GeneratedValue
  private Long moneyChangingRequestId;
  private String targetMembershipId;
  private int moneyChangingType;
  private int moneyAmount;
  private UUID uuid;
  @Temporal(TemporalType.TIMESTAMP)
  private Date timestamp;
  private int changingStatus;

  public MoneyChangingRequestJpaEntity(
      String targetMembershipId,
      int moneyChangingType,
      int moneyAmount,
      int changingStatus,
      UUID uuid,
      Date timestamp) {

    this.targetMembershipId = targetMembershipId;
    this.moneyChangingType = moneyChangingType;
    this.moneyAmount = moneyAmount;
    this.changingStatus = changingStatus;
    this.uuid = uuid;
    this.timestamp = timestamp;
  }

  public String toString() {
    return "MoneyChangingRequestJpaEntity{" +
        "moneyChangingRequestId=" + moneyChangingRequestId +
        ", targetMembershipId='" + targetMembershipId + '\'' +
        ", moneyChangingType=" + moneyChangingType +
        ", moneyAmount=" + moneyAmount +
        ", timestamp=" + timestamp +
        ", changingStatus=" + changingStatus +
        '}';
  }
}
