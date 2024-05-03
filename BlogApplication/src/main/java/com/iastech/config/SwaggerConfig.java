package com.iastech.config;




import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition( info = @Info(title = "Blogging Application: Backend Course",
description = "This is Blog-Application Project",
summary = "This project contains Apis for Blog Application",
termsOfService = "Terms&Conditions apply...",
contact = @Contact(name = "IRFAN SHAIKH",
email = "shaikhia9786@gmail.com",
url = "https://github.com/Irfan-9786"),
license = @License(name = "Irfan License"),
version = "ApiV1"),
servers = {@Server(description = "devEnv",url = "http://localhost:5000"),
		@Server(description = "prodEnv",url = "http://blogapplication-001-snapshot-env.eba-jq8ddum2.us-east-1.elasticbeanstalk.com")},
security = @SecurityRequirement(name = "Authorization")
)
@SecurityScheme(name="Authorization",
in=SecuritySchemeIn.HEADER,
type=SecuritySchemeType.APIKEY,
bearerFormat="Bearer",
description ="This is my basic security"
)

public class SwaggerConfig {

	/*
	 *Below code is alternative way to customize swagger
	 * @Bean OpenAPI getRestApiDocumentation() { return new OpenAPI() .info(new
	 * Info().title("Blogging Application: Backend Course")
	 * .description("Blog application with Spring Boot") .contact(new
	 * Contact().name("IRFAN SHAIKH ").email("shaikhia9786@gmail.com").url(
	 * "https://github.com/Irfan-9786")) .license(new
	 * License().name("Apache 2.0").url("http://insurance.org")) ) .externalDocs(new
	 * ExternalDocumentation()
	 * .description("In this project we have covered almost all features of Spring Boot"
	 * ) .url("https://github.com/Irfan-9786/Blog-app")); }
	 */
}

