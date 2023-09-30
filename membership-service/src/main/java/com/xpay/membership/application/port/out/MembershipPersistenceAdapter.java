package com.xpay.membership.application.port.out;

import com.xpay.membership.adapter.out.persistance.MembershipJpaEntity;
import com.xpay.membership.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

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
}
