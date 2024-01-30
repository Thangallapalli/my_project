package com.edubridge.app1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.app1.model.Car;
import com.edubridge.app1.model.Models;
import com.edubridge.app1.repo.CarRepository;

@Repository
public class CarDao {

	@Autowired
	private CarRepository repo;
	
	public Car saveCar(Car c) {
		return repo.save(c);
	}
	
	public List<Car> getCars(){
		return repo.findAll();
	}
	
	public Car getCar(Integer carId) {
		return repo.findById(carId).get();
	}
	
	public void updateCar(Car c) {
		repo.save(c);
	}
	
	public void deleteCar(Integer carId) {
		repo.deleteById(carId);
	}
	public List<Car>getCarsByModels(Models models){
		return repo.findByModels(models);
	}
	public List<Car>getCars(String model){
		return repo.findByModelContaining(model);
	}
}
