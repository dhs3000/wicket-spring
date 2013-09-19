package de.dennishoersch.web.rest_example.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import de.dennishoersch.web.rest_example.domain.Car;
import de.dennishoersch.web.rest_example.service.api.CarService;

public class CarServiceImpl implements CarService {

	//@formatter:off
	private static final List<Car> _CARS = new ImmutableList.Builder<Car>()
			.add(new Car(1, "VW", "Golf", 155))
			.add(new Car(2, "VW", "Polo", 125))
			.add(new Car(3, "BMW", "7er", 255))
			.add(new Car(4, "Opel", "Vectra", 55))
			.add(new Car(5, "Ford", "Fiesta", 1055))
			.build();
	//@formatter:on

	private final Map<Long, Car> _carDB = Maps.uniqueIndex(_CARS, new Function<Car, Long>() {
		@Override
		public Long apply(Car input) {
			return input.getId();
		}
	});

	@Override
	public Car getRandom() {
		return _carDB.get(randomIndex());
	}

	@Override
	public List<Car> getAll() {
		return ImmutableList.copyOf(_carDB.values());
	}

	@Override
	public Car getById(Long id) {
		return _carDB.get(id);
	}

	@Override
	public void save(Car car) {
		_carDB.put(car.getId(), car);
	}

	private Long randomIndex() {
		Random random = new Random();
		return Long.valueOf(1 + random.nextInt(_carDB.size() - 1));
	}

}
