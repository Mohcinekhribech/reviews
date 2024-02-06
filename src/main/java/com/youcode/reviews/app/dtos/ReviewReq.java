package com.youcode.reviews.app.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ReviewReq {
    private UUID id;
    private LocalDate date;
    private String title;
    private String message;
    private boolean report;
    private String reaction;
    private UUID user_id ;
}
