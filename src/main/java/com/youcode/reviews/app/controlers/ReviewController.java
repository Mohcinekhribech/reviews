package com.youcode.reviews.app.controlers;

import com.youcode.reviews.app.dtos.ReviewReq;
import com.youcode.reviews.app.dtos.ReviewResp;
import com.youcode.reviews.app.services.interfaces.ReviewServiceInterface;
import com.youcode.reviews.shareable.CrudController;
import com.youcode.reviews.shareable.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/reviews")
public class ReviewController extends CrudController<ReviewReq, ReviewResp, UUID , ReviewServiceInterface> {

    public ReviewController(ReviewServiceInterface reviewServiceInterface, ResponseMessage responseMessage) {
        super(reviewServiceInterface, responseMessage);
    }
}
