package com.example.test.service;

import java.util.Arrays;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.api.Exception.MovieAlreadyExistException;
import com.example.api.Exception.MovieNotFound;
import com.example.api.Repository.MovieRepository;
import com.example.api.Service.MovieService;
import com.example.api.Service.MovieServiceImp;
import com.example.api.entity.Movie;
import com.example.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class MovieServiceTest {

	@Mock
	private MovieRepository repository;
	
	@InjectMocks
	private MovieService service = new MovieServiceImp();
	
	private Movie movie;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		movie = new Movie();
		movie.setId(UUID.randomUUID().toString());
		movie.setActors("dummy dummy");
		movie.setAwards("dummy");
		movie.setCountry("dummy");
		movie.setDirector("dummy");
		movie.setGenre("dumy");
		movie.setImdbID("dummy");
		movie.setImdbRating("dummy");
		movie.setRated("dummy");
		movie.setImdbVotes("dummy");
		movie.setLanguage("dummy");
		movie.setMetascore("dummy");
		movie.setPlot("dummy dummy");
		movie.setReleased("dummy");
		movie.setPoster("dummy");
		movie.setRuntime("dummy");
		movie.setWriter("dummy");
		movie.setYear("dummy");
		movie.setTitle("dummy");
		movie.setType("dummy");
	}
	
	@Test
	public void testFindAll(){
		service.findAll();
		Mockito.verify(repository).findAll();
	}
	
	@Test
	public void testFindOne() {
		Mockito.when(repository.findOne(movie.getId())).thenReturn(movie);

		Movie actual = service.findOne(movie.getId());
		Assert.assertEquals(movie, actual);
	}
	
	@Test(expected = MovieNotFound.class)
	public void testFindOneException(){
		Mockito.when(repository.findOne(movie.getId())).thenReturn(null);

		service.findOne(movie.getId());
	}
	
	@Test
	public void testCreate() {
		Mockito.when(repository.searchByImdbID(movie.getImdbID())).thenReturn(null);
		service.create(movie);
		Mockito.verify(repository).create(movie);
	}
	
	@Test(expected = MovieAlreadyExistException.class)
	public void testCreateException() {
		Mockito.when(repository.searchByImdbID(movie.getImdbID())).thenReturn(Arrays.asList(movie));
		service.create(movie);
	}

}
