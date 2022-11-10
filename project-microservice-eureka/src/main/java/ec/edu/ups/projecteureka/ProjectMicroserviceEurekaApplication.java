package ec.edu.ups.projecteureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProjectMicroserviceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectMicroserviceEurekaApplication.class, args);
	}

}
