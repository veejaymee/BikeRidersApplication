package co.za.bike.race.bikerace.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bike Racer API")
                        .version("1.0.0")
                        .description("API for managing bike racers \n" +
                                "\n In this application will get the reports of the bike riders" +
                                "\n 1) All results who's rank is below 3" +
                                "\n 2) Single results per Race with first 3 ranks only" +
                                "\n 3) Not participated Riders results " +
                                "\n And current weather conditions also added to the results "))
                .components(new Components()
                        .addSecuritySchemes("basicAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")))
                .security(Arrays.asList(new SecurityRequirement().addList("basicAuth")))
                .tags(Arrays.asList(
                        new Tag()
                        .name("Racers")
                        .description("Endpoints for managing bike racers")));
    }
}
