package com.employer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * Configuration class for testing the CSI Document Management Service.
 * This class allows running the Spring Boot application with additional configurations
 * specifically designed for testing.
 *
 * <p>The {@link EmployerApplicationTests#main(String[])} method starts the application
 * with the configurations defined in both {@link EmployerApplication} and this class.
 * It enables additional testing features such as the use of a PostgreSQL Docker container.
 *
 * <p>The {@link EmployerApplicationTests#jdbcDatabaseContainer()} ()} method defines a Docker container
 * for PostgreSQL (version 15.4) and Oracle to be used during testing. This container is annotated with
 * {@link org.springframework.boot.devtools.restart.RestartScope},
 * indicating it's scoped for restarting with specific configurations.
 */
@Configuration
class EmployerApplicationTests {

	/**
	 * Main method to run the Spring Boot application with test configurations.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication
				// Do everything defined in EmployerApplication::main
				.from(EmployerApplication::main)
				// With additional configs in EmployerApplicationTests.class
				.with(EmployerApplicationTests.class)
				.run(args);
	}

	/**
	 * Defines a PostgreSQL Docker container for testing.
	 * This container is configured to use PostgreSQL version 15.4.
	 *
	 * @return A PostgreSQLContainer instance to be used during testing.
	 */
	@Bean
	@RestartScope
	@ServiceConnection
	JdbcDatabaseContainer jdbcDatabaseContainer() {
		return new PostgreSQLContainer("postgres:15.4");
	}

}
