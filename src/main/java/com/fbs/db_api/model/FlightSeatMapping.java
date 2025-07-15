package com.fbs.db_api.model;

import jakarta.persistence.*;
//this model will only use by non-connecting flights
import java.util.UUID;
@Entity
@Table(name = "flightseatmapping")
public class FlightSeatMapping extends SeatMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @ManyToOne
    Flight flight;
}
