package com.youcode.reviews.app.dtos;

import com.youcode.reviews.security.User.DTOs.UserDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ReviewResp {
    private UUID id;
    private LocalDate date;
    private String title;
    private String message;
    private boolean report;
    private String reaction;
    private UserDTO user;
}
