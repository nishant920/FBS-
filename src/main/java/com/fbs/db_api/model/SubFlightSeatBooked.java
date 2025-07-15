package com.fbs.db_api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class SubFlightSeatBooked {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;
    @ManyToOne
    SubFlight subFlight;
    @ManyToOne
    AppUser bookedBy;
    String passenger;
    boolean above18;
    int seatNumber;
}
