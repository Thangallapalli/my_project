package com.edubridge.app1.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.app1.dao.CarDao;
import com.edubridge.app1.model.Car;
import com.edubridge.app1.model.Models;

@Service
public class CarService {
	
	@Autowired
	private CarDao dao;

	public Car saveCar(Car c) {
		return dao.saveCar(c);
	}
	
	public List<Car> getCars(){
		return dao.getCars();
	}
	
	public Car getCar(Integer carId) {
		return dao.getCar(carId);
	}
	
	public void updateCar(Car c) {
		dao.updateCar(c);
	}
	
	public void deleteCar(Integer carId) {
		dao.deleteCar(carId);
	}
	
	public List<Car>getCarsByModels(Models models){
		return dao.getCarsByModels(models);
	}
	public List<Car>getCars(String model){
		return dao.getCars(model);
	}
}
