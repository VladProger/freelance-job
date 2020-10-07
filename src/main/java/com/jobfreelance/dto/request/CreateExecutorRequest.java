package com.jobfreelance.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class CreateExecutorRequest {

    @NotNull
    private Integer categoryId;

    @NotBlank
    private UUID customerUuid;
}
