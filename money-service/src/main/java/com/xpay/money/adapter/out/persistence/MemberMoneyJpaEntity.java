package com.xpay.money.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "member_money")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberMoneyJpaEntity {
  @Id
  @GeneratedValue
  private Long memberMoneyId;

  private Long membershipId;

  private int balance;

  private String aggregateIdentifier;
  public MemberMoneyJpaEntity(Long membershipId, int balance, String aggregateIdentifier) {
    this.membershipId = membershipId;
    this.balance = balance;
    this.aggregateIdentifier = aggregateIdentifier;
  }
}