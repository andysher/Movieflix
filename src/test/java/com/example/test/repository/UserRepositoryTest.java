package com.example.test.repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

import com.example.api.Repository.UserRepository;
import com.example.api.Repository.UserRepositoryImp;
import com.example.api.entity.User;
import com.example.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserRepositoryTest {

	@Mock
	private EntityManager em;

	@InjectMocks
	private UserRepository repository = new UserRepositoryImp();

	@Mock
	private TypedQuery<User> query;

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
		List<User> expected = Arrays.asList(user);

		Mockito.when(em.createQuery("from User", User.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<User> actual = repository.findAll();
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testFindOne() {
		Mockito.when(em.find(User.class, user.getId())).thenReturn(user);

		User actual = repository.findOne(user.getId());
		Assert.assertEquals(user, actual);
	}

	@Test
	public void testSearchByEmail() {
		List<User> expected = Arrays.asList(user);

		Mockito.when((em.createNamedQuery("User.findByEmail", User.class).setParameter("pEmail", user.getEmail()))).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<User> actual = repository.searchByEmail(user.getEmail());
		Assert.assertEquals(expected, actual);
	}
}
