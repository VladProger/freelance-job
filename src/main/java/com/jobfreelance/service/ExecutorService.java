package com.jobfreelance.service;


import com.jobfreelance.dto.CreateExecutorRequest;
import com.jobfreelance.dto.ExecutorDto;
import com.jobfreelance.entity.ExecutorEntity;
import com.jobfreelance.repository.ExecutorRepository;
import com.jobfreelance.translator.ExecutorTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ExecutorService {

    private final ExecutorRepository executorRepository;
    private final ExecutorTranslator executorTranslator;

    public ExecutorDto getExecutorByUcdmId(String ucdmId){
        return executorTranslator.mapEntityToDto(executorRepository.getByExecutorId(ucdmId));
    }

    public Boolean addNewExecutor(CreateExecutorRequest request){

        return executorRepository.save(ExecutorEntity.of()
                .executorId(UUID.randomUUID().toString())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .isEnabled(request.getIsEnabled())
                .phoneNumber(request.getPhoneNumber())
                .profession(request.getProfession())
                .role(request.getRole())
                .surname(request.getSurname())
                .status(request.getStatus()).build()) == null;
    }
}
