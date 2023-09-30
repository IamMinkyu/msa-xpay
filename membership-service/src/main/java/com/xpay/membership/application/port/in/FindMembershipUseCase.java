package com.xpay.membership.application.port.in;

import com.xpay.membership.domain.Membership;

public interface FindMembershipUseCase {
    Membership findMembership(FindMembershipCommand command);
    Membership findAxonMembership(FindMembershipCommand command);
}
