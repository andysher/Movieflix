package com.example.api.Repository;

import java.util.List;

import com.example.api.entity.Movie;

public interface MovieRepository {
	
	public List<Movie> findAll();

	public Movie findOne(String id);
	
	public List<Movie> searchByTitle(String title);
	
	public List<Movie> searchByType(String type);
	
	public List<Movie> searchByGenre(String genre);
	
	public List<Movie> searchByImdbID(String imdbID);

	public Movie create(Movie movie);
	
	public Movie update(Movie movie);

	public void delete(Movie movie);

	public List<Movie> topMovies();
	
	public List<Movie> topSeries();
}
