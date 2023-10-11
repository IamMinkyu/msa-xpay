package com.xpay.banking.adapter.in.web;

import com.xpay.banking.application.port.in.RequestFirmBankingCommand;
import com.xpay.banking.application.port.in.RequestFirmbankingUseCase;
import com.xpay.banking.domain.FirmbankingRequest;
import com.xpay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {

  private final RequestFirmbankingUseCase requestFirmbankingUseCase;
  @PostMapping("/banking/firmbanking/request")
  public FirmbankingRequest requestFirmbanking(@RequestBody RequestFirmBankingRequest request) {

    RequestFirmBankingCommand command = RequestFirmBankingCommand.builder()
        .fromBankName(request.getFromBankName())
        .fromBankAccountNumber(request.getFromBankAccountNumber())
        .toBankName(request.getToBankName())
        .toBankAccountNumber(request.getToBankAccountNumber())
        .moneyAmount(request.getMoneyAmount())
        .build();

    FirmbankingRequest firmBankingRequest = requestFirmbankingUseCase.requestFirmbanking(command);
    if (firmBankingRequest == null) {
      //TODO: 예외 처리
      return null;
    }
    return firmBankingRequest;
  }
}
