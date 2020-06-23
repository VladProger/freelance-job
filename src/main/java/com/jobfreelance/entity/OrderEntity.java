package com.jobfreelance.entity;

import lombok.Builder;
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
@Builder
@Table(name = "order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_uuid")
    private String customerUuid;

    @Column(name = "description")
    private String description;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "adress")
    private String adress;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "price")
    private String price;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "hackworker_uuid")
    private String hackworkerUuid;

}
