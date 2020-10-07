package com.jobfreelance.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CityDto {
    private List<String> cities = new ArrayList<>();
}
