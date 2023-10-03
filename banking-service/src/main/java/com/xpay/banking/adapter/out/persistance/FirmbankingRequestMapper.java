package com.xpay.banking.adapter.out.persistance;

import com.xpay.banking.domain.FirmbankingRequest;
import org.springframework.stereotype.Component;

@Component
public class FirmbankingRequestMapper {
  public FirmbankingRequest mapToDomainEntity(RequestFirmbankingJpaEntity entity) {
    return FirmbankingRequest.generateFirmBankingRequest(
        new FirmbankingRequest.FirmBankingRequestId(entity.getRequestFirmbankingId()),
        new FirmbankingRequest.FromBankName(entity.getFromBankName()),
        new FirmbankingRequest.FromBankAccountNumber(entity.getFromBankAccountNumber()),
        new FirmbankingRequest.ToBankName(entity.getToBankName()),
        new FirmbankingRequest.ToBankAccountNumber(entity.getToBankAccountNumber()),
        new FirmbankingRequest.MoneyAmount(entity.getMoneyAmount()),
        new FirmbankingRequest.FirmBankingStatus(entity.getFirmBankingStatus())
    );
  }
}
