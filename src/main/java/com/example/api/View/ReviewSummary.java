package com.example.api.View;

import java.util.List;

import com.example.api.entity.Review;

public interface ReviewSummary {
	
	public List<Review> generateSummaryView(List<Review> reviews);

}
