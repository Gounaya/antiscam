package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
    private String make;
    private String model;
    private String version;
    private String category;
    private String registerNumber;
    private Long mileage;
}
