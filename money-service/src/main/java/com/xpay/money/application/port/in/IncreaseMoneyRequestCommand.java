package com.xpay.money.application.port.in;

import com.xpay.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class IncreaseMoneyRequestCommand extends SelfValidating<IncreaseMoneyRequestCommand> {

  @NotNull
  private String targetMembershipId;
  @NotNull
  private int amount;

  public IncreaseMoneyRequestCommand(
      @NotNull String targetMembershipId,
      @NotNull int amount
  ) {

    this.targetMembershipId = targetMembershipId;
    this.amount = amount;

    this.validateSelf();
  }
}
