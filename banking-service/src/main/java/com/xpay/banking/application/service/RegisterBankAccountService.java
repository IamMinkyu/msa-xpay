package com.xpay.banking.application.service;

import com.xpay.banking.adapter.out.external.bank.BankAccount;
import com.xpay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.xpay.banking.adapter.out.persistance.RegisteredBankAccountJpaEntity;
import com.xpay.banking.adapter.out.persistance.RegisteredBankAccountMapper;
import com.xpay.banking.application.port.in.RegisterBankAccountCommand;
import com.xpay.banking.application.port.in.RegisterBankAccountUseCase;
import com.xpay.banking.application.port.out.RegisterBankAccountPort;
import com.xpay.banking.application.port.out.RequestBankAccountInfoPort;
import com.xpay.banking.domain.RegisteredBankAccount;
import com.xpay.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

  private final RegisterBankAccountPort registerBankAccountPort;
  private final RegisteredBankAccountMapper bankAccountMapper;
  private final RequestBankAccountInfoPort requestBankAccountInfoPort;
  @Override
  public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

    // 은행 계좌를 등록 해야 하는 서비스 (비즈니스 로직)

    // 0. 멤버가 정상인지 확인

    // 1. 외부 실제 은행에 등록이 가능한 계좌인지(정상인지) 확인한다.
    // Biz Logic -> External System
    // Port -> Adapter -> External System

    // Port -> 실제 은행 계좌 정보를 가져 온다.
    BankAccount bankAccountInfo = requestBankAccountInfoPort
        .getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));

    if (!bankAccountInfo.isValid()) {
      return null;
    }

    RegisteredBankAccountJpaEntity entity = registerBankAccountPort.createRegisteredBankAccount(
        new RegisteredBankAccount.MembershipId(command.getMembershipId()),
        new RegisteredBankAccount.BankName(command.getBankName()),
        new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
        new RegisteredBankAccount.LinkedStatusIsValid(command.isLinkedStatusIsValid()));

    return bankAccountMapper.mapToDomainEntity(entity);
  }
}
