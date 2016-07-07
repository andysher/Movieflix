package com.example.api.Service;

import java.util.List;

import com.example.api.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String id);
	
	public Movie create(Movie movie);
	
	public Movie update(String id, Movie movie);
	
	public void delete(String id);
}
