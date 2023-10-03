package com.xpay.money.adapter.in.web;

public enum ChangingType {
  INCREASE(1),
  DECREASE(-1);

  private final int type;

  private ChangingType(int type) {
    this.type = type;
  }
}
