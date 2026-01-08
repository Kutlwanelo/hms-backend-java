package com.hospital.hms_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pateints")

public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;

  @Column(unique = true) //This ensures two patients do not have the same email
  private String email;

  private String diagnosis;
  private String phoneNumber;
}
