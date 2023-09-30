package com.xpay.membership.application.port.out;

import com.xpay.membership.adapter.out.persistance.MembershipJpaEntity;
import com.xpay.membership.domain.Membership;

public interface ModifyMembershipPort {

    MembershipJpaEntity updateMembership(
        Membership.MembershipId membershipId,
        Membership.MembershipName membershipName,
        Membership.MembershipEmail membershipEmail,
        Membership.MembershipAddress membershipAddress,
        Membership.MembershipIsValid membershipIsValid,
        Membership.MembershipIsCorp membershipIsCorp
    );
}
