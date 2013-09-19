package de.dennishoersch.web.rest_example.service.api;

import java.util.List;

import de.dennishoersch.web.rest_example.domain.Car;

public interface CarService {
	public Car getRandom();
	public List<Car> getAll();
	public Car getById(Long id);
	public void save(Car car);
}