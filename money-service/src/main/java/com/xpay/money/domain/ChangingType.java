package com.xpay.money.domain;

enum ChangingType {

  INCREASING(1),
  DECREASING(-1);
  public final int type;

  private ChangingType(int type) {
    this.type = type;
  }
}
