package com.xpay.money.application.port.out;

import com.xpay.common.RechargingMoneyTask;

public interface SendRechargingMoneyTaskPort {
  void sendRechargingMoneyTaskPort(
      RechargingMoneyTask task
  );
}
