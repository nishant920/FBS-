package com.fbs.db_api.model;

import jakarta.persistence.*;
//this model will only use by non-connecting flights
import java.util.UUID;
@Entity
@Table(name = "flightseatmapping")
public class FlightSeatMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;
    @ManyToOne
    Flight flight;
    String className;
    String range; //1-20
    int basePrice;
    int windowPrice;
    int totalWindow;

}
