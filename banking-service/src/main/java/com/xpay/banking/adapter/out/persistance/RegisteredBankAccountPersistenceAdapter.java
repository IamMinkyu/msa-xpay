package com.xpay.banking.adapter.out.persistance;

import com.xpay.banking.application.port.out.RegisterBankAccountPort;
import com.xpay.banking.domain.RegisteredBankAccount;
import com.xpay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

  private final SpringDataRegisteredBankAccountRepository bankAccountRepository;
  @Override
  public RegisteredBankAccountJpaEntity createRegisteredBankAccount(
      RegisteredBankAccount.MembershipId membershipId,
      RegisteredBankAccount.BankName bankName,
      RegisteredBankAccount.BankAccountNumber bankAccountNumber,
      RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid) {

    return bankAccountRepository.save(new RegisteredBankAccountJpaEntity(
      membershipId.getMembershipId(),
      bankName.getBankName(),
      bankAccountNumber.getBankAccountNumber(),
      linkedStatusIsValid.isLinkedStatusIsValid()
    ));
  }
}
