package com.adalabs.tokens.user;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(UserController.class)
class UserControllerTest {

	@Autowired
	private UserController userController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserDetailsService userDetailsService;
	
	@Test
	public void register() {
		
		ApplicationUser user = new ApplicationUser();
		
		user.setUsername("james");
		user.setEmail("james@adalabs.com");
		user.setPassword("adalabs");
		
		when(userDetailsService.loadUserByUsername(toString()).thenReturn(user));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users/register"))
		.andExpect(MockMvcResultMatchers.jsonPath("username").value("james"))
		.andExpect(MockMvcResultMatchers.jsonPath("email").value("james@adalabs.com"))
		.andExpect(MockMvcResultMatchers.jsonPath("password").value("adalabs"))
		.andExpect(status().isOk());
	}

}
