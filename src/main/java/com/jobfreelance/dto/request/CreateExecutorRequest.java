package com.jobfreelance.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateExecutorRequest {

    @NotNull
    private Integer categoryId;

    @NotBlank
    private String customerUuid;
}
