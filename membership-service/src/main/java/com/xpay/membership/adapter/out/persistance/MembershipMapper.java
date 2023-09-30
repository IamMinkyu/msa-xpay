package com.xpay.membership.adapter.out.persistance;

import com.xpay.membership.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {

    public Membership mapToDomainEntity(MembershipJpaEntity entity) {
        return Membership.generateMember(
            new Membership.MembershipId(entity.getMembershipId()),
            new Membership.MembershipName(entity.getName()),
            new Membership.MembershipEmail(entity.getEmail()),
            new Membership.MembershipAddress(entity.getAddress()),
            new Membership.MembershipIsValid(entity.isValid()),
            new Membership.MembershipIsCorp(entity.isCorp())
        );
    }
}
