package com.xpay.money.application.port.in;


import com.xpay.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyRequestUseCase {
  MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);
  MoneyChangingRequest increaseMoneyRequestAsync(IncreaseMoneyRequestCommand command);
}
