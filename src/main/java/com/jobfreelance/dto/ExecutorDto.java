package com.jobfreelance.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class ExecutorDto {

    private String customerUuid;
    
    private Integer categoryId;

    private String description;
}
