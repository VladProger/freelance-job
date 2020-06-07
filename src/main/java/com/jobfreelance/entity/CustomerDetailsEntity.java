package com.jobfreelance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@Table(name = "customer_details")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    @Column(name = "phone_number", updatable = false)
    private String phoneNumber;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "customer_uuid")
    private String customerUuid;
}
