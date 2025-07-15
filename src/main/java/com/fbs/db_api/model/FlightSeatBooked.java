package com.fbs.db_api.model;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "flightbookedseats")
public class FlightSeatBooked {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;
    @ManyToOne
    Flight flight;
    @ManyToOne
    AppUser bookedBy;
    String passenger;
    boolean above18;
    int seatNumber;



}
