package com.xpay.banking.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRegisteredBankAccountRepository extends
    JpaRepository<RegisteredBankAccountJpaEntity, Long> { }
