package com.jobfreelance.translator;

import com.jobfreelance.dto.ExecutorDto;
import com.jobfreelance.entity.ExecutorEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorTranslator {

    public ExecutorDto mapEntityToDto(ExecutorEntity executorEntity){
        if (executorEntity == null)
            return null;
        return new ExecutorDto(executorEntity.getExecutorId(),
                executorEntity.getFirstName(),
                executorEntity.getSurname(),
                executorEntity.getRating(),
                executorEntity.getEmail(),
                executorEntity.getPhoneNumber(),
                executorEntity.getIsEnabled(),
                executorEntity.getRole(),
                executorEntity.getProfession(),
                executorEntity.getStatus());

    }
}
