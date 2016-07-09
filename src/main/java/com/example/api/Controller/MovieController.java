package com.example.api.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Service.MovieService;
import com.example.api.View.View;
import com.example.api.entity.Movie;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class MovieController {

	@Autowired
	private MovieService service;

	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("movieId") String movieID) {
		return service.findOne(movieID);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie) {
		return service.create(movie);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/genDB", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> createDB(@RequestBody List<Movie> movies) {
		return service.createDB(movies);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("movieId") String movieID, @RequestBody Movie movie) {
		return service.update(movieID, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{movieId}")
	public void delete(@PathVariable("movieId") String movieID) {
		service.delete(movieID);
	}

	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.POST, value = "/searchTitle", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Set<Movie> searchByTitle(@RequestBody List<String> titles) {
		return service.searchByTitle(titles);
	}

	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.GET, value = "/all/{type}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> searchbyTpye(@PathVariable("type") String type) {
		return service.searchByType(type);
	}
	
	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.GET, value = "/genre/{genre}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> searchByGenre(@PathVariable("genre") String genre) {
		return service.searchByGenre(genre);
	}

}
