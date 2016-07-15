package com.example.api.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.Exception.ReviewNotFound;
import com.example.api.Repository.ReviewRepository;
import com.example.api.View.ReviewSummary;
import com.example.api.entity.Movie;
import com.example.api.entity.Review;
import com.example.api.entity.User;

@Service
@Transactional
public class ReviewServiceImp implements ReviewService, ReviewSummary{
	
	@Autowired
	private ReviewRepository repository;

	@Override
	public List<Review> findAll(String movieId) {
		return generateSummaryView(repository.findAll(movieId));
	}

	@Override
	public Review findOne(String id) {
		Review existing = repository.findOne(id);
		if (existing == null)
			throw new ReviewNotFound("Review with id= " + id + "not found.");
		List<Review> temp = new ArrayList<Review>();
		temp.add(existing);
		return generateSummaryView(temp).get(0);
	}

	@Override
	public Review create(Review review) {
		Review r2 = repository.create(review);
		return findOne(r2.getId());
	}

	@Override
	public Review update(String id, Review review) {
		Review existing = repository.findOne(id);
		if (existing == null)
			throw new ReviewNotFound("Review with id= " + id + "not found.");
		List<Review> temp = new ArrayList<Review>();
		temp.add(repository.update(review));
		return generateSummaryView(temp).get(0);
	}

	@Override
	public void delete(String id) {
		Review existing = repository.findOne(id);
		if (existing == null)
			throw new ReviewNotFound("Review with id= " + id + "not found.");
		repository.delete(existing);
	}

	@Override
	public List<Review> generateSummaryView(List<Review> reviews) {
		List<Review> trim = new ArrayList<Review>();
		reviews.parallelStream().forEach(r -> {
			Review t = new Review();
			Movie m = new Movie();
			User u = new User();
			u.setId(r.getUser().getId());
			u.setFirstName(r.getUser().getFirstName());
			u.setLastname(r.getUser().getLastname());
			m.setId(r.getMovie().getId());
			t.setId(r.getId());
			t.setComment(r.getComment());
			t.setRating(r.getRating());
			t.setCreated(r.getCreated());
			t.setMovie(m);
			t.setUser(u);
			trim.add(t);
		});
		return trim;
	}

}
