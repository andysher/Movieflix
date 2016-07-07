package com.example.api.Repository;

import java.util.List;

import com.example.api.entity.Movie;

public interface MovieRepository {
	
	public List<Movie> findAll();

	public Movie findOne(String id);
	
	public Movie findByImdbId(String imdbID);
	
	public Movie findByTitle(String title);

	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie movie);
}
