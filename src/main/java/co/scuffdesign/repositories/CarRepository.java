package co.scuffdesign.repositories;

import org.springframework.data.repository.CrudRepository;

import co.scuffdesign.beans.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {

	public Car findById(int id);
	
}
