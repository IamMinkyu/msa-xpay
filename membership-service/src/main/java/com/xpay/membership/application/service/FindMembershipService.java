package com.xpay.membership.application.service;

import com.xpay.membership.adapter.out.persistance.MembershipJpaEntity;
import com.xpay.membership.adapter.out.persistance.MembershipMapper;
import com.xpay.membership.application.port.in.FindMembershipCommand;
import com.xpay.membership.application.port.in.FindMembershipUseCase;
import com.xpay.membership.application.port.out.FindMembershipPort;
import com.xpay.membership.domain.Membership;
import com.xpay.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity = findMembershipPort
                .findMembership(new Membership.MembershipId(Long.parseLong(command.getMembershipId())));

        return membershipMapper.mapToDomainEntity(entity);
    }

    @Override
    public Membership findAxonMembership(FindMembershipCommand command) {
        return null;
    }
}
