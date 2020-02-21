package com.jobfreelance.controller;

import com.jobfreelance.dto.CreateExecutorRequest;
import com.jobfreelance.dto.ExecutorDto;
import com.jobfreelance.service.ExecutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/executor")
public class ExecutorController {

    private final ExecutorService executorService;

    @GetMapping("{uuid}")
    public ExecutorDto getExecutorByUcdmId(@PathVariable(name = "uuid") String ucdmid){
        return executorService.getExecutorByUcdmId(ucdmid);
    }

    @PostMapping("/create-executor")
    public Boolean createExecutor(@RequestBody @Valid CreateExecutorRequest request){
        return executorService.addNewExecutor(request);
    }
}
