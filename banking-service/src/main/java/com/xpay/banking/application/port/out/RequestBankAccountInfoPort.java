package com.xpay.banking.application.port.out;

import com.xpay.banking.adapter.out.external.bank.BankAccount;
import com.xpay.banking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
  BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
