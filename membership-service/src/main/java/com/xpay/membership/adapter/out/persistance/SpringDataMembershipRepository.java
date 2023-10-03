package com.xpay.membership.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {

}
