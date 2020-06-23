package com.jobfreelance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "customer_uuid")
    private String customerUuid;

    @Column(name = "is_anonym")
    private Boolean isAnonym;

    @Column(name = "executor_id")
    private String executorId;

    @Column(name = "created_on")
    private Timestamp createdOn;

    public CommentEntity() {}

    public CommentEntity(String text, String customerUuid, Boolean isAnonym, String executorId, Timestamp createdOn) {
        this.createdOn = createdOn;
        this.customerUuid = customerUuid;
        this.executorId = executorId;
        this.isAnonym = isAnonym;
        this.text = text;
    }
}
