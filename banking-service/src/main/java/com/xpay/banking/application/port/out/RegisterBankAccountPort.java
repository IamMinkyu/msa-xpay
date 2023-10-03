package com.xpay.banking.application.port.out;

import com.xpay.banking.adapter.out.persistance.RegisteredBankAccountJpaEntity;
import com.xpay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

  RegisteredBankAccountJpaEntity createRegisteredBankAccount(
      RegisteredBankAccount.MembershipId membershipId,
      RegisteredBankAccount.BankName bankName,
      RegisteredBankAccount.BankAccountNumber bankAccountNumber,
      RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
  );
}
