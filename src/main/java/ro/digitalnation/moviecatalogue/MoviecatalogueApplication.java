package ro.digitalnation.moviecatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MoviecatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviecatalogueApplication.class, args);
	}

}
