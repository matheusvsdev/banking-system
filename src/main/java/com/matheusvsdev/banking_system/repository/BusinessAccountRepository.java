package com.matheusvsdev.banking_system.repository;

import com.matheusvsdev.banking_system.entity.BusinessAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessAccountRepository extends JpaRepository<BusinessAccountEntity, Long> {
}
