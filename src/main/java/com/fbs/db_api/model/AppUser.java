package com.fbs.db_api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;
    String Email;
    String Name;
    String Password;
    boolean isVerified;
    String UserType;
}
