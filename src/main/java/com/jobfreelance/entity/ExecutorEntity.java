package com.jobfreelance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "of")
@Table(name = "executor")
public class ExecutorEntity {
    @Id
    @Column(name = "executor_uuid")
    private String executorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "rating")
    private String rating;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "role")
    private Integer role;

    @Column(name = "profession")
    private String profession;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "last_online")
    private Timestamp lastOnline;
}
