package com.edubridge.app1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.app1.model.Car;
import com.edubridge.app1.model.Models;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
	List<Car>findByModels(Models models);
	List<Car>findByModelContaining(String model);
	

}
