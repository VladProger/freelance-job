package com.jobfreelance.repository;

import com.jobfreelance.entity.ExecutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutorRepository extends JpaRepository<ExecutorEntity, Integer> {
    ExecutorEntity getByCustomerUuid(String uuid);
}
