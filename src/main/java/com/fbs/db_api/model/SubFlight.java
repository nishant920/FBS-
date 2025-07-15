package com.fbs.db_api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class SubFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;
    @ManyToOne
    Flight flight;
    int priority;
    String sourceAirport;
    String destinationAirport;
    LocalDateTime boardingTime;
     int waitTime;
    LocalDateTime departingTime;
    LocalDateTime arrivalTime;
}
