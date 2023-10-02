package com.xpay.banking.adapter.out.external.bank;

import com.xpay.banking.application.port.out.RequestBankAccountInfoPort;
import com.xpay.common.ExternalSystemAdapter;

@ExternalSystemAdapter
public class BankAccountAdapter implements RequestBankAccountInfoPort {
  @Override
  public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

    return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
  }
}
