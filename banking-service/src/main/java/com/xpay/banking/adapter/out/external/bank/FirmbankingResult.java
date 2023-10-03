package com.xpay.banking.adapter.out.external.bank;

import lombok.Data;

@Data
public class FirmbankingResult {
  private int resultCode; // 0: 실패, 1: 성공

  public FirmbankingResult(int resultCode) {
    this.resultCode = resultCode;
  }
}
