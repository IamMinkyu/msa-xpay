package com.xpay.banking.adapter.out.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "request_firmbanking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestFirmbankingJpaEntity {
  @Id
  @GeneratedValue
  private long requestFirmbankingId;
  private String fromBankName;
  private String fromBankAccountNumber;
  private String toBankName;
  private String toBankAccountNumber;
  private int moneyAmount; //only own
  private String firmBankingStatus;
  private UUID uuid;

  public RequestFirmbankingJpaEntity(
    String fromBankName,
    String fromBankAccountNumber,
    String toBankName,
    String toBankAccountNumber,
    int moneyAmount,
    String firmBankingStatus,
    UUID uuid
  ) {
    this.fromBankName = fromBankName;
    this.fromBankAccountNumber = fromBankAccountNumber;
    this.toBankName = toBankName;
    this.toBankAccountNumber = toBankAccountNumber;
    this.moneyAmount = moneyAmount;
    this.firmBankingStatus = firmBankingStatus;
    this.uuid = uuid;
  }

  @Override
  public String toString() {
    return "RequestFirmBankingJpaEntity{" +
      "requestFirmBankingId=" + requestFirmbankingId +
      ", fromBankName='" + fromBankName + '\'' +
      ", fromBankAccountNumber='" + fromBankAccountNumber + '\'' +
      ", toBankName='" + toBankName + '\'' +
      ", toBankAccountNumber='" + toBankAccountNumber + '\'' +
      ", moneyAmount=" + moneyAmount +
      ", firmBankingStatus='" + firmBankingStatus + '\'' +
      '}';
  }
}
