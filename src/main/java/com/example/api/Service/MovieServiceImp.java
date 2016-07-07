package com.example.api.Service;

import java.util.List;

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
//		Movie existing = repository.findByImdbId(movie.getImdbID());
//		if (existing != null)
//			throw new MovieAlreadyExistException("Movie with imdb id=" + movie.getImdbID() + " already exists...");
		return repository.create(movie);
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

}
