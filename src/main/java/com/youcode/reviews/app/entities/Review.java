package com.youcode.reviews.app.entities;

import com.youcode.reviews.security.User.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate date;
    private String title;
    private String message;
    private boolean report;
    private String reaction;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}