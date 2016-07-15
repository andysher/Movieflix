package com.example.api.Service;

import java.util.List;

import com.example.api.entity.Review;

public interface ReviewService {
	
	public List<Review> findAll(String movieId);

	public Review findOne(String id);

	public Review create(Review review);
	
	public Review update(String id, Review review);

	public void delete(String id);

}
