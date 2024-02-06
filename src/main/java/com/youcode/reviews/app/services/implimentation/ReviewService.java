package com.youcode.reviews.app.services.implimentation;

import com.youcode.reviews.app.dtos.ReviewReq;
import com.youcode.reviews.app.dtos.ReviewResp;
import com.youcode.reviews.app.entities.Review;
import com.youcode.reviews.app.repositories.ReviewRepository;
import com.youcode.reviews.app.services.interfaces.ReviewServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ReviewService implements ReviewServiceInterface {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;
    @Override
    public ReviewResp create(ReviewReq reviewReq) {
        Review review =  reviewRepository.save(modelMapper.map(reviewReq,Review.class));
        return modelMapper.map(review,ReviewResp.class);
    }

    @Override
    public ReviewResp update(ReviewReq reviewReq, UUID id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        return reviewOptional.map(review -> {
            reviewReq.setId(review.getId());
            review = reviewRepository.save(modelMapper.map(reviewReq,Review.class));
            return modelMapper.map(review,ReviewResp.class);
        }).orElse(null);
    }

    @Override
    public Integer delete(UUID id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        return reviewOptional.map(review -> {
                    reviewRepository.delete(review);
                    return 1;
                })
                .orElse(0);
    }

    @Override
    public List<ReviewResp> getAll() {
        return reviewRepository.findAll().stream().map(review -> modelMapper.map(review,ReviewResp.class)).collect(Collectors.toList());
    }

    @Override
    public ReviewResp getOne(UUID id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        return modelMapper.map(reviewOptional.orElse(null),ReviewResp.class);
    }
}
