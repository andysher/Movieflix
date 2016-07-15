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
@RequestMapping("/browse")
public class FilterController {

	@Autowired
 	MovieService service;
	 
	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.POST, value = "/byTitle", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Set<Movie> searchByTitle(@RequestBody List<String> titles) {
		return service.searchByTitle(titles);
	}

	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.GET, value = "/all/{type}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> searchbyType(@PathVariable("type") String type) {
		return service.searchByType(type);
	}
	
	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.GET, value = "/genre/{genre}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> searchByGenre(@PathVariable("genre") String genre) {
		return service.searchByGenre(genre);
	}
	
	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.GET, value = "/toprated", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findTopRated() {
		return service.getTopRated();
	}
}
