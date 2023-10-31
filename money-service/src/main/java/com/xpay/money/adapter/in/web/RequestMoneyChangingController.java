package com.xpay.money.adapter.in.web;

import com.xpay.common.WebAdapter;
import com.xpay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.xpay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.xpay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestMoneyChangingController {

  private final IncreaseMoneyRequestUseCase increaseMoneyRequestUseCase;

  @PostMapping(path = "/money/increase")
  MoneyChangingResultDetail increaseMoneyChangingRequest(
      @RequestBody IncreaseMoneyChangingRequest request) {

    IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
        .targetMembershipId(request.getTargetMembershipId())
        .amount(request.getAmount())
        .build();

    MoneyChangingRequest moneyChangingRequest = increaseMoneyRequestUseCase.increaseMoneyRequest(command);

    // MoneyChangingRequest -> MoneyChangingResultDetail
    MoneyChangingResultDetail resultDetail = new MoneyChangingResultDetail(
        moneyChangingRequest.getMoneyChangingRequestId(),
        0,
        0,
        moneyChangingRequest.getChangingMoneyAmount());
    return resultDetail;
  }
}
