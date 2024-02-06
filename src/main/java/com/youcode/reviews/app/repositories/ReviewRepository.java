package com.youcode.reviews.app.repositories;

import com.youcode.reviews.app.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review,UUID> {
}
