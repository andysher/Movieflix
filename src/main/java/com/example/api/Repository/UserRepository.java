package com.example.api.Repository;

import java.util.List;

import com.example.api.entity.User;

public interface UserRepository {

	public List<User> findAll();

	public User findOne(String id);
	
	public List<User> searchByEmail(String email);

	public User create(User user);
	
	public User update(User user);

	public void delete(User user);
}
