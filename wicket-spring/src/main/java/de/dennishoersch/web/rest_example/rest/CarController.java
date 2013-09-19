package de.dennishoersch.web.rest_example.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.dennishoersch.web.rest_example.domain.Car;
import de.dennishoersch.web.rest_example.service.api.CarService;

@RequestMapping("cars")
public class CarController {

	@Inject
	private CarService carService;

	// cars
	@RequestMapping()
	@ResponseBody
	public List<Car> all() {
		return carService.getAll();
	}

	// cars/random
	@RequestMapping("random")
	@ResponseBody
	public Car randomPerson() {
		return carService.getRandom();
	}

	// cars/0
	@RequestMapping("{id}")
	@ResponseBody
	public Car getById(@PathVariable Long id) {
		return carService.getById(id);
	}

	// same as above method, just showing different URL mapping
	// cars?id=0
	@RequestMapping(params = "id")
	@ResponseBody
	public Car getByIdFromParam(@RequestParam Long id) {
		return carService.getById(id);
	}

	// // handles person form submit
	// @RequestMapping(value="...", method=RequestMethod.POST)
	// @ResponseBody
	// public String savePerson(...) {
	// service.save(...);
	// return "Saved : " + ....toString();
	// }
}