package com.xpay.banking.adapter.in.web;

import com.xpay.banking.application.port.in.RegisterBankAccountCommand;
import com.xpay.banking.application.port.in.RegisterBankAccountUseCase;
import com.xpay.banking.domain.RegisteredBankAccount;
import com.xpay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

  private final RegisterBankAccountUseCase registerBankAccountUseCase;
  @PostMapping("/banking/account/register")
  public RegisteredBankAccount registerBankAccount(@RequestBody RegisterBankAccountRequest request) {

    RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
        .membershipId(request.getMembershipId())
        .bankName(request.getBankName())
        .bankAccountNumber(request.getBankAccountNumber())
        .linkedStatusIsValid(request.isValid())
        .build();

    RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);
    if (registeredBankAccount == null) {
      //TODO: 예외 처리
      return null;
    }
    return registeredBankAccount;
  }
}
