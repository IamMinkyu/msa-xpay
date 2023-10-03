package com.xpay.banking.application.service;

import com.xpay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.xpay.banking.adapter.out.external.bank.FirmbankingResult;
import com.xpay.banking.adapter.out.persistance.FirmbankingRequestMapper;
import com.xpay.banking.adapter.out.persistance.RequestFirmbankingJpaEntity;
import com.xpay.banking.application.port.in.RequestFirmBankingCommand;
import com.xpay.banking.application.port.in.RequestFirmbankingUseCase;
import com.xpay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.xpay.banking.application.port.out.RequestFirmbankingPort;
import com.xpay.banking.domain.FirmbankingRequest;
import com.xpay.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmbankingService implements RequestFirmbankingUseCase {

  private final RequestFirmbankingPort requestFirmbankingPort;
  private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;
  private final FirmbankingRequestMapper mapper;
  @Override
  public FirmbankingRequest requestFirmbanking(RequestFirmBankingCommand command) {


    // Biz Logic
    // a -> b 계좌

    // 1. 요청에 대해 정보를 먼저 Write 한다. "요청" 상태로
    RequestFirmbankingJpaEntity entity = requestFirmbankingPort.createFirmbanking(
        new FirmbankingRequest.FromBankName(command.getFromBankName()),
        new FirmbankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
        new FirmbankingRequest.ToBankName(command.getToBankName()),
        new FirmbankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
        new FirmbankingRequest.MoneyAmount(command.getMoneyAmount()),
        new FirmbankingRequest.FirmBankingStatus("REQUESTED")
    );

    // 2. 외부 은행에 펌뱅킹 요청
    FirmbankingResult firmbankingResult = requestExternalFirmbankingPort.requestExternalFirmbanking(new ExternalFirmbankingRequest(
        command.getFromBankName(),
        command.getFromBankAccountNumber(),
        command.getToBankName(),
        command.getToBankAccountNumber(),
        command.getMoneyAmount(),
        entity.getUuid()
    ));

    // 3. 결과에 따라서 1번에 작성했던 FirmBankingRequest를 업데이트 한다. "완료" 상태로
    entity.setFirmBankingStatus(
        firmbankingResult.getResultCode() == 1
        ? "SUCCESS"
        : "FAIL");

    // 4. 결과를 리턴 한다.
    return mapper.mapToDomainEntity(requestFirmbankingPort.modifyFirmbanking(entity));
  }
}
