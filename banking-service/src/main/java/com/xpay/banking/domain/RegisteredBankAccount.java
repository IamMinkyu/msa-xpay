package com.xpay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBankAccount {
  private final Long registeredBankAccountId;
  private final String membershipId;
  private final String bankName;
  private final String bankAccountNumber;
  private final boolean linkedStatusIsValid;

  public static RegisteredBankAccount generateRegisteredBankAccount(
    RegisteredBankAccount.RegisteredBankAccountId registeredBankAccountId,
    RegisteredBankAccount.MembershipId membershipId,
    RegisteredBankAccount.BankName bankName,
    RegisteredBankAccount.BankAccountNumber bankAccountNumber,
    RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
  ) {
    return new RegisteredBankAccount(
      registeredBankAccountId.getRegisteredBankAccountId(),
      membershipId.getMembershipId(),
      bankName.getBankName(),
      bankAccountNumber.getBankAccountNumber(),
      linkedStatusIsValid.isLinkedStatusIsValid()
    );
  }
  @Value
  public static class RegisteredBankAccountId {
    Long registeredBankAccountId;
    public RegisteredBankAccountId(Long value) {
      this.registeredBankAccountId = value;
    }
  }

  @Value
  public static class MembershipId {
    String membershipId;
    public MembershipId(String value) {
      this.membershipId = value;
    }
  }

  @Value
  public static class BankName {
    String bankName;
    public BankName(String value) {
      this.bankName = value;
    }
  }

  @Value
  public static class BankAccountNumber {
    String bankAccountNumber;
    public BankAccountNumber(String value) {
      this.bankAccountNumber = value;
    }
  }

  @Value
  public static class LinkedStatusIsValid {
    boolean linkedStatusIsValid;
    public LinkedStatusIsValid(boolean value) {
      this.linkedStatusIsValid = value;
    }
  }
}


