package com.jobfreelance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class OrderDto {
    private String customerUuid;

    private String description;

    private String photoUrl;

    private String adress;

    private Timestamp endDate;

    private String price;

    private Integer orderStatus;

    private String hackworkerUuid;
}
