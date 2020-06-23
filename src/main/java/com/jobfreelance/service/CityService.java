package com.jobfreelance.service;

import com.jobfreelance.dto.CityDto;
import com.jobfreelance.entity.CityEntity;
import com.jobfreelance.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    public CityDto getAvailableCities(){
        CityDto cityDto = new CityDto();
        List<CityEntity> cityEntity = cityRepository.findAll();
        for (CityEntity entity:cityEntity) {
            cityDto.getCities().add(entity.getCity());
        }
        return cityDto;
    }
}
