package com.xpay.banking.application.port.out;

import com.xpay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.xpay.banking.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {
  FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request);
}
