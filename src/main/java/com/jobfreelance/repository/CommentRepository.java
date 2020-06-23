package com.jobfreelance.repository;

import com.jobfreelance.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends JpaRepository<CommentEntity, Long> {
    CommentEntity findByCustomerUuid(String customerUuid);
}
