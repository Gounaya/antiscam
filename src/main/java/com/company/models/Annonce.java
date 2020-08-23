package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Annonce {
    private Contacts contacts;
    private Date creationDate;
    private Long price;
    private List<String> publicationOptions;
    private String reference;
    private Vehicule vehicle;
}
