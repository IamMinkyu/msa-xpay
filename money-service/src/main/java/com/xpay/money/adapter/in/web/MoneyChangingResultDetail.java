package com.xpay.money.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {

  private String moneyChangingRequestId;
  private ChangingType moneyChangingType;
  private MoneyChangingResultStatus moneyChangingResultStatus;
}

