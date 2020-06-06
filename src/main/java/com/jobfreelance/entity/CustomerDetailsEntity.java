package com.jobfreelance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
public class CustomerDetailsEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "age")
    private Integer age;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "pnohe_number")
    private String pnoheNumber;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "customer_uuid")
    private String customer_uuid;
}
