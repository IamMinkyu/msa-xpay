package com.xpay.banking.adapter.out.persistance;

import com.xpay.banking.application.port.out.RequestFirmbankingPort;
import com.xpay.banking.domain.FirmbankingRequest;
import com.xpay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestFirmbankingPersistenceAdapter implements RequestFirmbankingPort {

  private final SpringDataRequestFirmbankingRepository requestFirmBankingRepository;
  @Override
  public RequestFirmbankingJpaEntity createFirmbanking(
      FirmbankingRequest.FromBankName fromBankName,
      FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber,
      FirmbankingRequest.ToBankName toBankName,
      FirmbankingRequest.ToBankAccountNumber toBankAccountNumber,
      FirmbankingRequest.MoneyAmount moneyAmount,
      FirmbankingRequest.FirmBankingStatus status) {

    return requestFirmBankingRepository
      .save(new RequestFirmbankingJpaEntity(
        fromBankName.getFromBankName(),
        fromBankAccountNumber.getFromBankAccountNumber(),
        toBankName.getToBankName(),
        toBankAccountNumber.getToBankAccountNumber(),
        moneyAmount.getMoneyAmount(),
        status.getFirmBankingStatus(),
        UUID.randomUUID()
    ));
  }

  @Override
  public RequestFirmbankingJpaEntity modifyFirmbanking(RequestFirmbankingJpaEntity eneity) {
    return requestFirmBankingRepository.save(eneity);
  }
}
