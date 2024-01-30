package com.edubridge.app1.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Car_details")
public class Car {
	@Id
	@GeneratedValue
	private Integer carId;
	private String carNumber;
	private String imageUrl;
	private String model;
	private String status;
	private Double rentPrice;
	
	@ManyToOne
	@JoinColumn(name ="modelId")
	private Models models;
	
	
	
	public Car() {
		super();
	}



	public Car(Integer carId, String carNumber, String imageUrl, String model, String status, Double rentPrice,
			Models models) {
		super();
		this.carId = carId;
		this.carNumber = carNumber;
		this.imageUrl = imageUrl;
		this.model = model;
		this.status = status;
		this.rentPrice = rentPrice;
		this.models = models;
	}



	public Integer getCarId() {
		return carId;
	}



	public void setCarId(Integer carId) {
		this.carId = carId;
	}



	public String getCarNumber() {
		return carNumber;
	}



	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Double getRentPrice() {
		return rentPrice;
	}



	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}



	public Models getModels() {
		return models;
	}



	public void setModels(Models models) {
		this.models = models;
	}



	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carNumber=" + carNumber + ", imageUrl=" + imageUrl + ", model=" + model
				+ ", status=" + status + ", rentPrice=" + rentPrice + ", models=" + models + "]";
	}



}
