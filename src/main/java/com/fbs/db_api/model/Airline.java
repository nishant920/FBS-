package com.fbs.db_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Airline {

    UUID id;
    String manufacturer;
    int modelNumber;
    int modelName;
    LocalDate buildDate;
    @ManyToOne
    Airline airline;

}
