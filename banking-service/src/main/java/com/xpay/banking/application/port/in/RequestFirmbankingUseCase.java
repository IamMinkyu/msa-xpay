package com.xpay.banking.application.port.in;

import com.xpay.banking.domain.FirmbankingRequest;

public interface RequestFirmbankingUseCase {
  FirmbankingRequest requestFirmbanking(RequestFirmBankingCommand command);
}
