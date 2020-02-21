package com.jobfreelance.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExecutorDto {

    private String executorId;

    private String firstName;

    private String surname;

    private String rating;

    private String email;

    private String phoneNumber;

    private Boolean isEnabled;

    private Integer role;

    private String profession;

    private Integer status;
}
