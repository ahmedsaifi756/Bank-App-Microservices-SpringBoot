package com.eliteartisans.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication

/*@ComponentScans({ @ComponentScan("com.eliteartisans.accounts.controller") })
@EnableJpaRepositories("com.eliteartisans.accounts.repository")
@EntityScan("com.eliteartisans.accounts.model")*/

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "EliteArtisans Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Mohd Ahmed",
						email = "ahmedsaifi756@gmail.com",
						url = "https://www.linkedin.com/in/mohd-ahmed-30903920a/"
				),
				license = @License(
						name = "Apache 2.0"
				)
		),
				externalDocs = @ExternalDocumentation(
						description =  "EliteArtisans Accounts microservice REST API Documentation from By @Madan Reddy",
						url = "https://www.eazybytes.com/swagger-ui.html"
				)				
		)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
