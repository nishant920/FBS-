package com.fbs.db_api.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;
    @Column
    String Email;
    String Name;
    String Password;
    boolean isVerified;
    String UserType;
}
