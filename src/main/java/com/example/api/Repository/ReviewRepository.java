package com.example.api.Repository;

import java.util.List;

import com.example.api.entity.Review;

public interface ReviewRepository {
	
	public List<Review> findAll(String movieID);

	public Review findOne(String id);
	

	public Review create(Review review);
	
	public Review update(Review review);

	public void delete(Review review);

}
