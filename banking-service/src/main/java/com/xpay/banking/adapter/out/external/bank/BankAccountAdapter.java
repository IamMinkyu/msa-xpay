package com.xpay.banking.adapter.out.external.bank;

import com.xpay.banking.application.port.out.RequestBankAccountInfoPort;
import com.xpay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.xpay.common.ExternalSystemAdapter;

@ExternalSystemAdapter
public class BankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmbankingPort {
  @Override
  public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

    // 실제 외부 은행에 HTTP 요청해서 실제 계좌 정보를 가져온다.
    // 실제 은행 계좌 정보 -> BankAccount
    return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
  }

  @Override
  public FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request) {
    // 실제 외부 은행에 HTTP 요청해서 펌뱅킹 요청을 한다.
    // 그 결과를 우리가 필요한 형태로 파싱한다. -> FirmbankingResult
    return new FirmbankingResult(1);
  }
}
