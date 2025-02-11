package com.jobfreelance.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class EditDesciptionRequest {

    private String description;

    @NotBlank
    private UUID customerUuid;
}
