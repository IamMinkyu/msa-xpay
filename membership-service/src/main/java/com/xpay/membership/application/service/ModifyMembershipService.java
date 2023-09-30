package com.xpay.membership.application.service;

import com.xpay.membership.adapter.out.persistance.MembershipJpaEntity;
import com.xpay.membership.adapter.out.persistance.MembershipMapper;
import com.xpay.membership.application.port.in.ModifyMembershipCommand;
import com.xpay.membership.application.port.in.ModifyMembershipUseCase;
import com.xpay.membership.application.port.in.RegisterMembershipCommand;
import com.xpay.membership.application.port.in.RegisterMembershipUseCase;
import com.xpay.membership.application.port.out.ModifyMembershipPort;
import com.xpay.membership.application.port.out.RegisterMembershipPort;
import com.xpay.membership.domain.Membership;
import common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        // command -> db
        MembershipJpaEntity jpaEntity = modifyMembershipPort.updateMembership(
            new Membership.MembershipId(Long.parseLong(command.getMembershipId())),
            new Membership.MembershipName(command.getName()),
            new Membership.MembershipEmail(command.getEmail()),
            new Membership.MembershipAddress(command.getAddress()),
            new Membership.MembershipIsValid(command.isValid()),
            new Membership.MembershipIsCorp(command.isCorp()));

        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
