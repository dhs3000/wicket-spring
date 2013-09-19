package de.dennishoersch.web.rest_example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import de.dennishoersch.web.rest_example.rest.CarController;
import de.dennishoersch.web.rest_example.service.api.CarService;
import de.dennishoersch.web.rest_example.service.impl.CarServiceImpl;

@Configuration
@EnableWebMvc
public class RestConfiguration {

	@Bean
	public CarService carService() {
		return new CarServiceImpl();
	}

	@Bean
	public CarController cars() {
		return new CarController();
	}
}
