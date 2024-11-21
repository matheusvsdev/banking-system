package com.matheusvsdev.banking_system.repository;

import com.matheusvsdev.banking_system.entity.PersonalAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalAccountRepository extends JpaRepository<PersonalAccountEntity, Long> {
}
