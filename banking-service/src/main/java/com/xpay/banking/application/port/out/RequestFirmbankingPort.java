package com.xpay.banking.application.port.out;

import com.xpay.banking.adapter.out.persistance.RequestFirmbankingJpaEntity;
import com.xpay.banking.domain.FirmbankingRequest;

public interface RequestFirmbankingPort {
  RequestFirmbankingJpaEntity createFirmbanking(
      FirmbankingRequest.FromBankName fromBankName,
      FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber,
      FirmbankingRequest.ToBankName toBankName,
      FirmbankingRequest.ToBankAccountNumber toBankAccountNumber,
      FirmbankingRequest.MoneyAmount moneyAmount,
      FirmbankingRequest.FirmBankingStatus status);

  RequestFirmbankingJpaEntity modifyFirmbanking(
      RequestFirmbankingJpaEntity eneity);
}
