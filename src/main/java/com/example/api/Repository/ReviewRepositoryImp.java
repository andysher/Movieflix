package com.example.api.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.api.entity.Review;

@Repository
public class ReviewRepositoryImp implements ReviewRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Review> findAll(String movieID) {
		TypedQuery<Review> query = em.createQuery("SELECT r FROM Review r WHERE r.movie.id LIKE :pMovieID", Review.class)
				.setParameter("pMovieID", movieID);
		return query.getResultList();
	}

	@Override
	public Review findOne(String id) {
		return em.find(Review.class, id);
	}

	@Override
	public Review create(Review review) {
		em.persist(review);
		return review;
	}

	@Override
	public Review update(Review review) {
		return em.merge(review);
	}

	@Override
	public void delete(Review review) {
		em.remove(review);
	}

}
