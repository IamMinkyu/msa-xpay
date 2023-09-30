package com.xpay.membership.application.port.out;

import com.xpay.membership.adapter.out.persistance.MembershipJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {

}
