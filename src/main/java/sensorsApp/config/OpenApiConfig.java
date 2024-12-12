package sensorsApp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenApi configuration
 */
@Configuration
//@SecurityScheme(
//        name = "Bearer Authentication",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        scheme = "bearer"
//)
public class OpenApiConfig {
    @Bean
    public OpenAPI SensorsApp() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sensors API")
                        .description("Sensors measurement storage with REST API")
                        .version("0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .contact(new Contact().name("Vladimir Vlasenko").email("v.g.vlasenko@yandex.ru").url(""))
                );
    }
}