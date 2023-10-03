package com.xpay.banking.application.port.in;

import com.xpay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RequestFirmBankingCommand extends SelfValidating<RequestFirmBankingCommand> {

    private final String fromBankName;
    private final String fromBankAccountNumber;
    private final String toBankName;
    private final String toBankAccountNumber;
    private final int moneyAmount; //only own

    public RequestFirmBankingCommand(
        String fromBankName,
        String fromBankAccountNumber,
        String toBankName,
        String toBankAccountNumber,
        int moneyAmount) {

      this.fromBankName = fromBankName;
      this.fromBankAccountNumber = fromBankAccountNumber;
      this.toBankName = toBankName;
      this.toBankAccountNumber = toBankAccountNumber;
      this.moneyAmount = moneyAmount;

      this.validateSelf();
    }
}
