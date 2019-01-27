package com.example.utils;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                title = "Example ModelMapper Server Swagger API",
                description = "Example ModelMapper  Server Swagger API",
                version = "0.0.1",
                contact = @Contact(
                        name = "Hector Medeiros",
                        email = "hector.medeiros@ccc.ufcg.edu.br",
                        url = "https://github.com/hectorhm"
                ),
                license = @License(
                        name = "License",
                        url = "http://www.license.url"
                )
        ),
        consumes = { "application/json", "application/xml" },
        produces = { "application/json", "application/xml" },
        schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS },
        externalDocs = @ExternalDocs(value = "Read This", url = "https://github.com/hectorhm/modelMapper")
)
public class ApiDocumentationConfig {

}