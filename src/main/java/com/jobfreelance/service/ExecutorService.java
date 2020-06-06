package com.jobfreelance.service;


import com.jobfreelance.dto.CreateExecutorRequest;
import com.jobfreelance.dto.ExecutorDto;
import com.jobfreelance.entity.ExecutorEntity;
import com.jobfreelance.repository.ExecutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExecutorService {

    private final ExecutorRepository executorRepository;

    public ExecutorDto getExecutorByUcdmId(String ucdmId){
       ExecutorEntity entity = executorRepository.getByCustomerUuid(ucdmId);
       return new ExecutorDto(entity.getCustomerUuid(), entity.getCategoryId());
    }

    public Boolean addNewExecutor(CreateExecutorRequest request){
        ExecutorEntity entity = new ExecutorEntity();
        entity.setCustomerUuid(request.getCustomerUuid());
        entity.setCategoryId(request.getCategoryId());
        return executorRepository.save(entity).getId() != null;
    }
}
