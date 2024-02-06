package com.youcode.reviews.security.User.DTOs;

import com.youcode.reviews.security.User.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserRequest {
    private UUID id;
    @NotBlank(message = "fullName cannot be blank")
    @Size(max = 255, message = "fullName must not exceed 255 characters")
    private String fullName;

    @NotNull(message = "Date of birth cannot be null")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "email cannot be blank")
    @Size(max = 1000, message = "Email must not exceed 1000 characters")
    private String email;
    @NotBlank(message = "password cannot be blank")
    @Size(min = 8, message = "Password must exceed 8  characters")
    private String password;

    private Role role;
}
