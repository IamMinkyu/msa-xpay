package com.xpay.money.adapter.in.web;

enum MoneyChangingResultStatus {
  SUCCEEDED(2),
  FAILED(-4),
  FAILED_NOT_ENOUGH_MONEY(-5),
  FAILED_NOT_EXIST_MEMBERSHIP(-6),
  FAILED_NOT_EXIST_MONEY_CHANGING_REQUEST(-7);

  private final int status;

  private MoneyChangingResultStatus(int status) {
    this.status = status;
  }
}
