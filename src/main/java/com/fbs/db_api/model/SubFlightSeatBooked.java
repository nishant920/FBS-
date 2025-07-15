package com.fbs.db_api.model;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "subflightbookedseat")
public class SubFlightSeatBooked {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne
    SubFlight flight;
    @ManyToOne
    AppUser bookedBy;
}
