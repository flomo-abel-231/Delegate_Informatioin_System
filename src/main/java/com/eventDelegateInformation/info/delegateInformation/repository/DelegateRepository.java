package com.eventDelegateInformation.info.delegateInformation.repository;

import com.eventDelegateInformation.info.delegateInformation.entity.Delegate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelegateRepository extends JpaRepository<Delegate, Long> {

}
