package org.rado.libraryapigateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "org.rado")
@Getter
@Setter
public class LibraryApiGatewayConfigProps {

    private String bookApiId;
    private String bookApiPath;
    private String bookApiUrl;
    private String ratingApiId;
    private String ratingApiPath;
    private String ratingApiUrl;
}
