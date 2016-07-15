package com.example.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Service.UserService;
import com.example.api.View.View;
import com.example.api.entity.User;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll() {
		 return service.findAll();
	}

	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.GET, value = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("userId") String userID) {
		return service.findOne(userID);
	}

	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.PUT, value = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("userId") String userID, @RequestBody User user) {
		return service.update(userID, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
	public void delete(@PathVariable("userId") String userID) {
		service.delete(userID);
	}
	
	@JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.POST, value = "/auth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findByEmail(@RequestBody User user) {
		return service.userAuth(user);
	}
}
