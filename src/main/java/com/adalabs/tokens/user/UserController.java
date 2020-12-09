package com.adalabs.tokens.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/users")

public class UserController {
	private ApplicationUserRepository applicationUserRepository;
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	public UserController(ApplicationUserRepository applicationUserRepository,
			BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.applicationUserRepository = applicationUserRepository;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;

	}

	@PostMapping("/register")
	public void register(@RequestBody ApplicationUser user) {
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		applicationUserRepository.save(user);
		
	}

}
