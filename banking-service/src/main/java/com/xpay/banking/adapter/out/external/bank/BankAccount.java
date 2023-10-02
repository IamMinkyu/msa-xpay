package com.xpay.banking.adapter.out.external.bank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BankAccount {
  private String bankName;
  private String bankAccountNumber;
  private boolean isValid;

  public BankAccount(String bankName, String bankAccountNumber, boolean b) {
    // 외부 시스템에서 정보를 가져온다고 가정
    this.bankName = bankName;
    this.bankAccountNumber = bankAccountNumber;
    this.isValid = b;
  }
}
