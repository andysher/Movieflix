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
	public List<Movie> searchByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class).setParameter("pTitle",
				"%" + title + "%");
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> searchByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByType", Movie.class).setParameter("pType", type);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> searchByGenre(String genre) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByGenre", Movie.class).setParameter("pGenre", "%" + genre + "%");
		List<Movie> movies = query.getResultList();
		return movies;
	}

}
