package com.edubridge.app1.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Car_Models")
public class Models {

	@Id
	@GeneratedValue
	private Integer ModelId;
	private String modelName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Car> cars;
	
	public Models() {
		super();
	}

	public Models(Integer modelId, String modelName, Set<Car> cars) {
		super();
		ModelId = modelId;
		this.modelName = modelName;
		this.cars = cars;
	}

	public Integer getModelId() {
		return ModelId;
	}

	public void setModelId(Integer modelId) {
		ModelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Models [ModelId=" + ModelId + ", modelName=" + modelName + ", cars=" + cars + "]";
	}
	
	
	
}
