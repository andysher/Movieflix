package com.example.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.Exception.UserAlreadyExistException;
import com.example.api.Exception.UserAuthFailedException;
import com.example.api.Exception.UserNotFound;
import com.example.api.Repository.UserRepository;
import com.example.api.entity.User;
import com.example.api.entity.UserType;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User existing = repository.findOne(id);
		if (existing == null)
			throw new UserNotFound("Movie with id= " + id + "not found.");
		return existing;
	}

	@Override
	public User create(User user) {
		List<User> existing = repository.searchByEmail(user.getEmail().toLowerCase());
		if (existing == null) {
			user.setType(UserType.User.name());
			return repository.create(user);
		}else
			throw new UserAlreadyExistException("User with emailID=" 
		+ user.getEmail()+" already exists in the database");
	}

	@Override
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if (existing == null)
			throw new UserNotFound("User with id=" + id + " not found");
		return repository.update(user);
	}

	@Override
	public void delete(String id) {
		User existing = repository.findOne(id);
		if (existing == null)
			throw new UserNotFound("User with id=" + id + " not found");
		repository.delete(existing);
	}

	@Override
	public User userAuth(User user) {
		List<User> users = repository.searchByEmail(user.getEmail().toLowerCase());
		if(users != null && users.size()==1)
			if(user.getPassword().equals(users.get(0).getPassword()))
				return users.get(0);
		throw new UserAuthFailedException("User authentication with emailId=" + user.getEmail() + " failed");
	}

}
