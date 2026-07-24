package hn.ficohsa.msvc_ficohsa_insurance.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hn.ficohsa.msvc_ficohsa_insurance.documentation.OpenApiDoc;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(new Info()
            .title(OpenApiDoc.TITLE)
            .description(OpenApiDoc.DESCRIPTION)
            .version(OpenApiDoc.VERSION)
            .contact(new Contact()
                .name(OpenApiDoc.CONTACT_NAME)
                .email(OpenApiDoc.CONTACT_EMAIL)))
        .addSecurityItem(new SecurityRequirement().addList(OpenApiDoc.SECURITY_SCHEME_NAME))
        .components(new Components()
            .addSecuritySchemes(OpenApiDoc.SECURITY_SCHEME_NAME,
                new SecurityScheme()
                    .name(OpenApiDoc.SECURITY_SCHEME_NAME)
                    .type(SecurityScheme.Type.HTTP)
                    .scheme(OpenApiDoc.SECURITY_SCHEME)
                    .bearerFormat(OpenApiDoc.SECURITY_BEARER_FORMAT)
                    .description(OpenApiDoc.SECURITY_DESCRIPTION)));
  }
}
