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

    private String firstName;

    private String lastName;

    private String secondName;

    private Integer age;

    private String email;

    private String city;

    private String country;

    @NotBlank
    private String customerUuid;

    private String photoUrl;
}
