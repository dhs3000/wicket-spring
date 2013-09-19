package de.dennishoersch.web.wicket.model;

import javax.inject.Inject;

import org.apache.wicket.model.LoadableDetachableModel;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import de.dennishoersch.web.rest_example.domain.Car;
import de.dennishoersch.web.rest_example.service.api.CarService;

@Configuration
public class Models {
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public LoadableDetachableModel<Car> carModel(long id) {
		return new CarModel(id);
	}

	private static class CarModel extends LoadableDetachableModel<Car> {
		private static final long serialVersionUID = 1L;

		@Inject
		private CarService carService;

		private final Long _id;

		CarModel(long id) {
			_id = Long.valueOf(id);
		}

		@Override
		protected Car load() {
			return carService.getById(_id);
		}
	}
}
