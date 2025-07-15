package com.fbs.db_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;
    @Column(nullable = false)
    String Name;
    @Column(nullable = false, unique = true)
    String Email;
    @Column(nullable = false)
    String Password;
    @Column(nullable = false)
    boolean isVerified;
    @Column(nullable = false)
    String UserType;
}
