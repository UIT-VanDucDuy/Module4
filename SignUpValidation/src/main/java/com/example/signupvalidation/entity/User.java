package com.example.signupvalidation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "First name is required")
    @Size(min = 5, max = 45, message = "First name must be between 5 and 45 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 5, max = 45, message = "Last name must be between 5 and 45 characters")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
}
