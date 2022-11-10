package ec.edu.ups.projectgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProjectMicroserviceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectMicroserviceGatewayApplication.class, args);
	}

}
