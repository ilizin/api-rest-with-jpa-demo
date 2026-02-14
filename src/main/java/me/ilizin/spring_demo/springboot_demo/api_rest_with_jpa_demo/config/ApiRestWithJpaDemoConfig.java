package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class ApiRestWithJpaDemoConfig implements WebMvcConfigurer {

    @Autowired
    private BuildProperties buildProperties;

 /*   @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                        .version(buildProperties.getVersion())
                        .title(buildProperties.getName())
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
    }*/

    @Bean
    public OpenAPI customOpenAPI() throws IOException {
        ClassPathResource resource = new ClassPathResource("api-rest-with-jpa-demo-swagger.yaml");
        Path path = Paths.get(resource.getURI());
        String content = new String(Files.readAllBytes(path));
        SwaggerParseResult result = new OpenAPIV3Parser().readContents(content);
        if (result.getMessages().isEmpty() && result.getOpenAPI() != null) {
            return result.getOpenAPI();
        } else {
            throw new RuntimeException("Failed to parse OpenAPI definition: " + result.getMessages());
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api-docs/**").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springdoc-openapi-ui/");
    }
}
