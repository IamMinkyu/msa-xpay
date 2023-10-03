package com.xpay.money.domain;

public enum ChangingMoneyStatus {
  REQUESTED(1),
  SUCCEEDED(2),
  CANCELED(3),
  FAILED(-4);

  private final int status;
  private ChangingMoneyStatus(int status) {
    this.status = status;
  }
}
