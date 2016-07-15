package com.example.test.controller;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.api.Controller.UserController;
import com.example.api.Exception.UserNotFound;
import com.example.api.Service.UserService;
import com.example.api.entity.User;
import com.example.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@WebAppConfiguration
public class UserControllerTest {

	@Mock
	private UserService service;

	@InjectMocks
	private UserController controller;
	
	private MockMvc mockMvc;
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
		
		mockMvc = MockMvcBuilders
				.standaloneSetup(controller)
				.build();
	}
	
	
	@Test
	public void testFindAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/users"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(service).findAll();
	}
	
	@Test
	public void testFindOne() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/users/" + user.getId()))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(service).findOne(user.getId());
	}
	
	@Test
	public void testFindOneNotFound() throws Exception {
		Mockito.when(service.findOne(user.getId())).thenThrow(UserNotFound.class);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users/ashakhada"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(service).findOne(user.getId());
	}
	
}
