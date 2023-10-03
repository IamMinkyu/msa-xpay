package com.xpay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FirmbankingRequest {
  private final Long firmBankingRequestId;
  private final String fromBankName;
  private final String fromBankAccountNumber;
  private final String toBankName;
  private final String toBankAccountNumber;
  private final int moneyAmount; //only won
  private final String firmBankingStatus;
  private UUID uuid;

  public static FirmbankingRequest generateFirmBankingRequest(
    FirmBankingRequestId firmBankingRequestId,
    FromBankName fromBankName,
    FromBankAccountNumber fromBankAccountNumber,
    ToBankName toBankName,
    ToBankAccountNumber toBankAccountNumber,
    MoneyAmount moneyAmount,
    FirmBankingStatus firmBankingStatus
  ) {
    return new FirmbankingRequest(
      firmBankingRequestId.getFirmBankingRequestId(),
      fromBankName.getFromBankName(),
      fromBankAccountNumber.getFromBankAccountNumber(),
      toBankName.getToBankName(),
      toBankAccountNumber.getToBankAccountNumber(),
      moneyAmount.getMoneyAmount(),
      firmBankingStatus.getFirmBankingStatus(),
      UUID.randomUUID()
    );
  }
  @Value
  public static class FirmBankingRequestId {
    Long firmBankingRequestId;
    public FirmBankingRequestId(Long value) {
      this.firmBankingRequestId = value;
    }
  }

  @Value
  public static class FromBankName {
    String fromBankName;
    public FromBankName(String value) {
      this.fromBankName = value;
    }
  }
  @Value
  public static class FromBankAccountNumber {
    String fromBankAccountNumber;
    public FromBankAccountNumber(String value) {
      this.fromBankAccountNumber = value;
    }
  }
  @Value
  public static class ToBankName {
    String toBankName;
    public ToBankName(String value) {
      this.toBankName = value;
    }
  }
  @Value
  public static class ToBankAccountNumber {
    String toBankAccountNumber;
    public ToBankAccountNumber(String value) {
      this.toBankAccountNumber = value;
    }
  }
  @Value
  public static class MoneyAmount {
    int moneyAmount;
    public MoneyAmount(int value) {
      this.moneyAmount = value;
    }
  }
  @Value
  public static class FirmBankingStatus {
    String firmBankingStatus;
    public FirmBankingStatus(String value) {
      this.firmBankingStatus = value;
    }
  }
}


