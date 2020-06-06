package com.jobfreelance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class CommentEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "customer_uuid")
    private String customerUuid;

    @Column(name = "is_anonym")
    private Boolean isAnonym;
}
