package com.xpay.membership.application.port.in;

import com.xpay.membership.domain.Membership;

public interface ModifyMembershipUseCase {
  Membership modifyMembership(ModifyMembershipCommand command);
}
