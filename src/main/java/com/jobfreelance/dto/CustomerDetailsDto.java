package com.jobfreelance.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String secondName;

    private Integer age;

    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    private Boolean isEnabled;

    private String city;

    private String country;

    private String customerUuid;
}
