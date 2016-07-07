package com.example.api.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entity.User;
import com.example.api.entity.UserType;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll() {
		 List<User> UserList = new ArrayList<>();
		 User nw = new User();
		 nw.setFirstName("Andy");
		 nw.setLastname("Sher");
		 nw.setEmail("xyx@xyx.com");
		 nw.setPassword("xyz");
		 nw.setType(UserType.Admin.name());
		 UserList.add(nw);
		 return UserList;
//		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("userId") String userID) {
		return null;
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user) {
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("userId") String userID, @RequestBody User user) {
		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
	public void delete(@PathVariable("userId") String userID) {

	}
}
