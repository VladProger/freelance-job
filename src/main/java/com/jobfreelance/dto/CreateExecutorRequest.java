package com.jobfreelance.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class CreateExecutorRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    private Boolean isEnabled = true;

    @NotNull
    private Integer role;

    @NotBlank
    private String profession;

    @NotNull
    private Integer status;
}
