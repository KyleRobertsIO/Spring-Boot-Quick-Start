package co.scuffdesign.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.scuffdesign.beans.Car;
import co.scuffdesign.beans.exceptions.ApiRequestException;
import co.scuffdesign.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	CarRepository carRepo;
	
	public Car GetCarById(int carId) throws ApiRequestException {
		Car searchedCar = null;	
		try {
			searchedCar = carRepo.findById(carId);
		} catch(Exception e) {
			throw ErrorConnectionToDatabaseFailed();
		}
		if (searchedCar == null) {
			throw ErrorCarNotFound();
		}
		return searchedCar;
	}
	
	public Car InsertCar(Car car) throws ApiRequestException {
		Car newCar = null;
		car.setId(0);
		try {
			newCar = carRepo.save(car);
		} catch(Exception e) {
			throw ErrorConnectionToDatabaseFailed();
		}
		return newCar;
	}
	
	// Exception methods
	public ApiRequestException ErrorConnectionToDatabaseFailed() {
		ApiRequestException exception = new ApiRequestException(
			"Connection failed to data source"
		);
		exception.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return exception;
	}
	
	public ApiRequestException ErrorCarNotFound() {
		ApiRequestException exception = new ApiRequestException(
			"Could not find car."
		);
		exception.setHttpStatus(HttpStatus.NOT_FOUND);
		return exception;
	}
}
