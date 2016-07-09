package com.example.api.Service;

import java.util.List;
import java.util.Set;

import com.example.api.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie create(Movie movie);

	public List<Movie> createDB(List<Movie> movies);

	public Movie update(String id, Movie movie);

	public void delete(String id);

	public Set<Movie> searchByTitle(List<String> titles);

	public List<Movie> searchByType(String type);
	
	public List<Movie> searchByGenre(String genre);
}
