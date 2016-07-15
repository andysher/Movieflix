package com.example.test.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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

import com.example.api.Exception.UserAlreadyExistException;
import com.example.api.Exception.UserAuthFailedException;
import com.example.api.Exception.UserNotFound;
import com.example.api.Repository.UserRepository;
import com.example.api.Service.UserService;
import com.example.api.Service.UserServiceImp;
import com.example.api.entity.User;
import com.example.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserServiceTest {

	@Mock
	private UserRepository repository;

	@InjectMocks
	private UserService service = new UserServiceImp();

	private User user;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setFirstName("Dummy");
		user.setLastname("User");
		user.setPassword("pass");
		user.setEmail("dummy@dummy.com");
		user.setType("fake");
	}

	@Test
	public void testFindAll() {
		service.findAll();
		Mockito.verify(repository).findAll();
	}

	@Test
	public void testFindOne() {
		Mockito.when(repository.findOne(user.getId())).thenReturn(user);

		User actual = service.findOne(user.getId());
		Assert.assertEquals(user, actual);
	}

	@Test(expected = UserNotFound.class)
	public void testFindOneException(){
		Mockito.when(repository.findOne(user.getId())).thenReturn(null);

		service.findOne(user.getId());
	}
	
	@Test
	public void testCreate() {
		Mockito.when(repository.searchByEmail(user.getEmail())).thenReturn(null);
		service.create(user);
		Mockito.verify(repository).create(user);
	}
	
	@Test(expected = UserAlreadyExistException.class)
	public void testCreateException() {
		Mockito.when(repository.searchByEmail(user.getEmail())).thenReturn(Arrays.asList(user));
		service.create(user);
	}
	
	@Test
	public void testUserAuth() {
		List<User> expected = Arrays.asList(user);
		Mockito.when(repository.searchByEmail(user.getEmail())).thenReturn(expected);
		
		User actual = service.userAuth(user);
		Assert.assertEquals(expected.get(0), actual);
	}
	
	@Test(expected=UserAuthFailedException.class)
	public void testUserAuthException() {
		Mockito.when(repository.searchByEmail(user.getEmail())).thenReturn(null);
		
		service.userAuth(user);
	}

}
