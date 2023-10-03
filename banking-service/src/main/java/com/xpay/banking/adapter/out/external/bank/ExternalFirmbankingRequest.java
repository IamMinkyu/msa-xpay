package com.xpay.banking.adapter.out.external.bank;

import lombok.Data;

import java.util.UUID;

@Data
public class ExternalFirmbankingRequest {

  private String fromBankName;
  private String fromBankAccountNumber;
  private String toBankName;
  private String toBankAccountNumber;
  private int moneyAmount;
  private UUID uuid;

  public ExternalFirmbankingRequest(
      String fromBankName,
      String fromBankAccountNumber,
      String toBankName,
      String toBankAccountNumber,
      int moneyAmount,
      UUID uuid) {

    this.fromBankName = fromBankName;
    this.fromBankAccountNumber = fromBankAccountNumber;
    this.toBankName = toBankName;
    this.toBankAccountNumber = toBankAccountNumber;
    this.moneyAmount = moneyAmount;
    this.uuid = uuid;
  }
}
