package com.edubridge.app1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.app1.model.Car;
import com.edubridge.app1.model.Models;
import com.edubridge.app1.service.CarService;
import com.edubridge.app1.service.ModelService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
	private CarService service;

	@Autowired
	private ModelService modelsservice;
	
	@PostMapping("/car")
	public ResponseEntity<Car> save(@RequestBody Car car){
		Car savedCar = service.saveCar(car);
		return new ResponseEntity<>(savedCar, HttpStatus.OK);
	}

	@GetMapping("/car")
	public ResponseEntity<List<Car>> getAllCars(){
	    List<Car> cars =service.getCars();
	    return new ResponseEntity<>(cars, HttpStatus.OK);
	}
	
	@GetMapping("/car/{id}")
	public ResponseEntity<Car> getOneCar(@PathVariable("id") Integer carId){
		Car car = service.getCar(carId);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	
		@DeleteMapping("/car/{id}")
		public ResponseEntity<Car> deleteCar(@PathVariable("id") Integer carId){
		    service.deleteCar(carId);
			return new ResponseEntity<Car>(HttpStatus.OK);
	}
		@PutMapping("/car{id}")
		public ResponseEntity<Car> update(@RequestBody Car car){
		    service.saveCar(car);
		    return new ResponseEntity<>(HttpStatus.OK);
		}
		
		@GetMapping("/car/carsByModels/{modelId}")
		public ResponseEntity<List<Car>>getCarsByModels(@PathVariable Integer modelId){
			Models models=modelsservice.getModel(modelId);
			List<Car> cars=service.getCarsByModels(models);
			return new ResponseEntity<>(cars,HttpStatus.OK);
		}
		
		@GetMapping("/car/search/{model}")
		 public ResponseEntity<List<Car>>getModelContainingcar(@PathVariable String model){
			List<Car> cars=service.getCars(model);
			return new ResponseEntity<>(cars,HttpStatus.OK);
		}

}




