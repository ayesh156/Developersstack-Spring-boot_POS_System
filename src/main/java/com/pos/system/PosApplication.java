package com.pos.system;

import com.pos.system.service.ApplicationUserService;
import com.pos.system.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class PosApplication implements CommandLineRunner {

	private final UserRoleService userRoleService;
	private final ApplicationUserService applicationUserService;

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// save all user roles if not exists
		userRoleService.initializeRoles();
		// save the admin if not exists
		applicationUserService.initializeUser();
	}
}
