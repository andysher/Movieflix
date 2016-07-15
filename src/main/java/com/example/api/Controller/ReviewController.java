package com.example.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Service.ReviewService;
import com.example.api.entity.Review;

@RestController
@RequestMapping("/{movieId}/reviews")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Review> findALl(@PathVariable("movieId") String movieID) {
		return service.findAll(movieID);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{reviewId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review findOne(@PathVariable("movieId") String movieID, @PathVariable("reviewId") String reviewID) {
		return service.findOne(reviewID);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review create(@PathVariable("movieId") String movieID,@RequestBody Review review) {
		return service.create(review);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{reviewId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review update(@PathVariable("movieId") String movieID, @PathVariable("reviewId") String reviewID, @RequestBody Review review) {
		return service.update(reviewID, review);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{reviewId}")
	public void delete(@PathVariable("movieId") String movieID, @PathVariable("reviewId") String reviewID) {
		service.delete(reviewID);
	}
}
