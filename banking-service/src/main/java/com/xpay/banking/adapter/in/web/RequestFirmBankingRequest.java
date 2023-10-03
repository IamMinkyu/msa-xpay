package com.xpay.banking.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestFirmBankingRequest {
  //A -> B 실물계좌로 송금을 요청하기 위한 Request
  private String fromBankName;
  private String fromBankAccountNumber;
  private String toBankName;
  private String toBankAccountNumber;
  private int moneyAmount; //only won
}
