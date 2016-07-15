package com.example.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.example.api.View.View;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
@JsonInclude(Include.NON_NULL)
@NamedQueries({ @NamedQuery(name = "Movie.findByImdbId", query = "SELECT m FROM Movie m WHERE m.imdbID = :pImdbID"),
		@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE lower(m.title) LIKE :pTitle"),
		@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE lower(m.type) LIKE :pType"),
		@NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m WHERE lower(m.genre) LIKE :pGenre") })
public class Movie {

	@JsonView(View.Summary.class)
	@Id
	@GenericGenerator(strategy = "uuid2", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private String id;

	@JsonView(View.Summary.class)
	@JsonProperty("Title")
	private String title;
	@JsonView(View.Summary.class)
	@JsonProperty("Year")
	private String year;
	@JsonProperty("Rated")
	private String rated;
	@JsonProperty("Released")
	private String released;
	@JsonProperty("Runtime")
	private String runtime;
	@JsonProperty("Genre")
	@JsonView(View.Summary.class)
	private String genre;
	@JsonProperty("Director")
	private String director;
	@Column(length = 500)
	@JsonProperty("Writer")
	private String writer;
	@JsonProperty("Actors")
	private String actors;
	@Column(length = 500)
	@JsonProperty("Plot")
	private String plot;
	@JsonProperty("Language")
	private String language;
	@JsonProperty("Country")
	private String country;
	@JsonProperty("Awards")
	private String awards;
	@Column(length = 500)
	@JsonView(View.Summary.class)
	@JsonProperty("Poster")
	private String poster;
	@JsonProperty("Metascore")
	private String metascore;
	@JsonView(View.Summary.class)
	private String imdbRating;
	@JsonView(View.Summary.class)
	private String imdbVotes;

	@Column(unique = true)
	private String imdbID;
	@JsonProperty("Type")
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getMetascore() {
		return metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
