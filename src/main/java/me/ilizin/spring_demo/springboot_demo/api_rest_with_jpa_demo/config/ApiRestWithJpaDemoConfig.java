package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiRestWithJpaDemoConfig {

    @Autowired
    private BuildProperties buildProperties;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                        .version(buildProperties.getVersion())
                        .title("Api rest with JPA demo")
                        .description("A CRUD API rest with Jpa/hibernate (h2) demo project")
                        .contact(new Contact()
                                .name("Contact the developer")
                                .url("https://github.com/ilizin"))
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("Find out more about Swagger")
                        .url("https://swagger.io/"));
    }
}
