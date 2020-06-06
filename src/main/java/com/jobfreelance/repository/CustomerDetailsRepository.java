package com.jobfreelance.repository;

import com.jobfreelance.entity.CustomerDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetailsEntity, Long> {
    CustomerDetailsEntity getByCustomerUuid(String uuid);


}
