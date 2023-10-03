package com.xpay.banking.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRequestFirmbankingRepository extends
    JpaRepository<RequestFirmbankingJpaEntity, Long> { }
