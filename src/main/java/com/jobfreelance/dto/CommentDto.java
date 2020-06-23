package com.jobfreelance.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    @NotBlank
    private String text;

    @NotBlank
    private String customerUuid;

    @NotNull
    private Boolean isAnonym;

    @NotBlank
    private String executorId;

    @JsonIgnore
    private Timestamp createdOn;
}
