package org.rado.libraryapigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryApiGatewayBeanConfig {

    private final LibraryApiGatewayConfigProps libraryApiGatewayConfigProps;

    @Autowired
    public LibraryApiGatewayBeanConfig(LibraryApiGatewayConfigProps libraryApiGatewayConfigProps) {
        this.libraryApiGatewayConfigProps = libraryApiGatewayConfigProps;
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(this.libraryApiGatewayConfigProps.getBookApiId(), bookApi -> {
                    return bookApi
                            .path(this.libraryApiGatewayConfigProps.getBookApiPath())
                            .uri(this.libraryApiGatewayConfigProps.getBookApiUrl());
                })
                .route(this.libraryApiGatewayConfigProps.getRatingApiId(), ratingApi -> {
                    return ratingApi
                            .path(this.libraryApiGatewayConfigProps.getRatingApiPath())
                            .uri(this.libraryApiGatewayConfigProps.getRatingApiUrl());
                })
                .build();
    }
}
