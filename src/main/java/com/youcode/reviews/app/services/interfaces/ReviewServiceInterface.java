package com.youcode.reviews.app.services.interfaces;

import com.youcode.reviews.app.dtos.ReviewReq;
import com.youcode.reviews.app.dtos.ReviewResp;
import com.youcode.reviews.shareable.CrudInterface;

import java.util.UUID;

public interface ReviewServiceInterface extends CrudInterface<ReviewReq, ReviewResp , UUID> {
}
