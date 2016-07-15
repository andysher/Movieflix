package com.example.api.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.Exception.MovieAlreadyExistException;
import com.example.api.Exception.MovieNotFound;
import com.example.api.Repository.MovieRepository;
import com.example.api.entity.Movie;

@Service
@Transactional
public class MovieServiceImp implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null)
			throw new MovieNotFound("Movie with id= " + id + "not found.");
		return existing;
	}

	@Override
	public Movie create(Movie movie) {
		List<Movie> existing = repository.searchByImdbID(movie.getImdbID());
		if (existing.size() == 0)
			return repository.create(movie);
		else
			throw new MovieAlreadyExistException("Movie with imdbID=" 
		+ movie.getImdbID()+" already exists in the database");

	}

	@Override
	public List<Movie> createDB(List<Movie> movies) {
		List<Movie> temp = new ArrayList<Movie>();
		movies.forEach(t -> temp.add(repository.create(t)));
		return temp;
	}

	@Override
	public Movie update(String id, Movie movie) {
		Movie existing = repository.findOne(id);
		if (existing == null)
			throw new MovieNotFound("User with id=" + id + " not found");
		return repository.update(movie);
	}

	@Override
	public void delete(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null)
			throw new MovieNotFound("User with id=" + id + " not found");
		repository.delete(existing);
	}

	@Override
	public Set<Movie> searchByTitle(List<String> titles) {
		Set<Movie> temp = new HashSet<Movie>();
		titles.forEach(t -> temp.addAll(repository.searchByTitle(t.toLowerCase())));
		return temp;
	}

	@Override
	public List<Movie> searchByType(String type) {
		return repository.searchByType(type.toLowerCase());
	}

	@Override
	public List<Movie> searchByGenre(String genre) {
		return repository.searchByGenre(genre.toLowerCase());
	}

	@Override
	public List<Movie> getTopRated() {
		List<Movie> allMovies = new ArrayList<Movie>();
		allMovies.addAll(repository.topMovies());
		allMovies.addAll(repository.topSeries());
		return allMovies;
	}

}
