package com.example.api.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.api.entity.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createQuery("from Movie", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}

	@Override
	public Movie findByImdbId(String imdbID) {
		TypedQuery<Movie> query = em.createQuery("Movie.findByImdbId", Movie.class);
		query.setParameter("pImdbID", imdbID);
		List<Movie> movies = query.getResultList();
		if (movies != null && movies.size() == 1)
			return movies.get(0);
		else
			return null;
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}

	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies = query.getResultList();
		if (movies != null && movies.size() == 1)
			return movies.get(0);
		else
			return null;
	}

	
	@Override
	public List<Movie> findAllMovies() {
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.Type = 'movie'", Movie.class);
		return query.getResultList();
	}

	
	@Override
	public List<Movie> findAllTVSeries() {
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.Type = 'series'", Movie.class);
		return query.getResultList();
	}

}
