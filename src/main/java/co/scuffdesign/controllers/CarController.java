package co.scuffdesign.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.scuffdesign.beans.Car;
import co.scuffdesign.services.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping(path="/{carId}", produces="application/json")
	public Car getCarById(@PathVariable("carId") int carId) {
		return carService.GetCarById(carId);
	}
	
	@PostMapping(path="", consumes="application/json", produces="application/json")
	public Car getCarById(@RequestBody @Valid Car car) {
		return carService.InsertCar(car);
	}
	
}
