package ec.edu.ups.projectgateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {

    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("securities", r->r.path("/securities/**").uri("http://localhost:8762")) //static routing
                .route("games", r->r.path("/games/**").uri("lb://game-service")) //dynamic routing
                .build();
    }
}
