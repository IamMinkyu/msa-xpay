package com.xpay.banking.application.port.in;

import com.xpay.banking.domain.RegisteredBankAccount;
import com.xpay.common.UseCase;

public interface RegisterBankAccountUseCase {
  RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
