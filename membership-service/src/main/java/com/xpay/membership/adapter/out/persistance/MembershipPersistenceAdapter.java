package com.xpay.membership.adapter.out.persistance;

import com.xpay.membership.application.port.out.FindMembershipPort;
import com.xpay.membership.application.port.out.ModifyMembershipPort;
import com.xpay.membership.application.port.out.RegisterMembershipPort;
import com.xpay.membership.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;
    @Override
    public MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp) {

        return membershipRepository.save(
            new MembershipJpaEntity(
              membershipName.getNameValue(),
              membershipEmail.getEmailValue(),
              membershipAddress.getAddressValue(),
              membershipIsValid.isValidValue(),
              membershipIsCorp.isCorpValue())
        );
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getById(membershipId.getMembershipIdValue());
    }

    @Override
    public MembershipJpaEntity updateMembership(
        Membership.MembershipId membershipId,
        Membership.MembershipName membershipName,
        Membership.MembershipEmail membershipEmail,
        Membership.MembershipAddress membershipAddress,
        Membership.MembershipIsValid membershipIsValid,
        Membership.MembershipIsCorp membershipIsCorp) {

        MembershipJpaEntity entity = this.findMembership(membershipId);
        entity.setName(membershipName.getNameValue());
        entity.setEmail(membershipEmail.getEmailValue());
        entity.setAddress(membershipAddress.getAddressValue());
        entity.setValid(membershipIsValid.isValidValue());
        entity.setCorp(membershipIsCorp.isCorpValue());

        return membershipRepository.save(entity);
    }
}
