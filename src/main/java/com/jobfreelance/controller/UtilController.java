package com.jobfreelance.controller;

import com.jobfreelance.dto.CityDto;
import com.jobfreelance.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/util")
@RequiredArgsConstructor
public class UtilController {

    private final CityService cityService;

    @GetMapping
    public CityDto getCities(){
        return cityService.getAvailableCities();
    }
}
