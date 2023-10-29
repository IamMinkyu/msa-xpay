package com.xpay.money.adapter.in.web;

public class MoneyChangingResultDetail {
  private String moneyChangingRequestId;
  // 증액, 감액
  private int moneyChangingType; // 0: 증액, 1: 감액
  private int moneyChangingResultStatus; // 0: 성공, 실패, 실패 - 잔액 부족, 실패 - 멤버십 없음, 실패 - 머니 변액 요청 없음
  private int amount;
  public MoneyChangingResultDetail(String moneyChangingRequestId, int moneyChangingType, int moneyChangingResultStatus, int amount) {
    this.moneyChangingRequestId = moneyChangingRequestId;
    this.moneyChangingType = moneyChangingType;
    this.moneyChangingResultStatus = moneyChangingResultStatus;
    this.amount = amount;
  }
}
