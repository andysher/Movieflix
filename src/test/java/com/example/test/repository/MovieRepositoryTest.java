package com.example.test.repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

import com.example.api.Repository.MovieRepository;
import com.example.api.Repository.MovieRepositoryImp;
import com.example.api.entity.Movie;
import com.example.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class MovieRepositoryTest {

	@Mock
	private EntityManager em;

	@InjectMocks
	private MovieRepository repository = new MovieRepositoryImp(); 
	
	@Mock
	private TypedQuery<Movie> query;
	
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
	public void testFindAll() {
		List<Movie> expected = Arrays.asList(movie);

		Mockito.when(em.createQuery("from Movie", Movie.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<Movie> actual = repository.findAll();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testFindOne() {
		Mockito.when(em.find(Movie.class, movie.getId())).thenReturn(movie);

		Movie actual = repository.findOne(movie.getId());
		Assert.assertEquals(movie, actual);
	}
	
	@Test
	public void testCreate() {
		repository.create(movie);
		Mockito.verify(em).persist(movie);
	}
	
	@Test
	public void testUpdate() {
		repository.update(movie);
		Mockito.verify(em).merge(movie);
	}
	
	@Test
	public void testDelete() {
		repository.delete(movie);
		Mockito.verify(em).remove(movie);
	}
	
	@Test
	public void testSearchByTitle() {
		List<Movie> expected = Arrays.asList(movie);

		Mockito.when(em.createNamedQuery("Movie.findByTitle", Movie.class))
				.thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<Movie> actual = repository.searchByTitle(movie.getTitle());
		Assert.assertEquals(expected, actual);
	}
	
	
	
	
	
	
}
