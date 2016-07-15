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
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
@JsonInclude(Include.NON_NULL)
@NamedQueries({ @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE lower(u.email) LIKE :pEmail") })
public class User {

	@Id
	@GenericGenerator(strategy = "uuid2", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	@JsonView(View.Summary.class)
	private String id;

	@JsonView(View.Summary.class)
	private String firstName;
	@JsonView(View.Summary.class)
	private String lastName;

	@JsonView(View.Summary.class)
	@Column(unique = true)
	private String email;
	private String password;
	@JsonView(View.Summary.class)
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
