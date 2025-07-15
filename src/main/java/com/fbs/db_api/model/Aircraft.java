package com.fbs.db_api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.UUID;

public class Aircraft {
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;

    String manufacturer;


}
