package com.xpay.membership.application.port.out;

import com.xpay.membership.adapter.out.persistance.MembershipJpaEntity;
import com.xpay.membership.domain.Membership;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(Membership.MembershipId membershipId);
}
