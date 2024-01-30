package com.edubridge.app1.model;



import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rental_details")
public class Rentals {
	@Id
	@GeneratedValue
	private Integer rentalId;
	private String rentDate;
	private String timeDepart;
	private String timeArrive;
	private String returnDate;
	private double rentFee;
	
	@ManyToOne(cascade = CascadeType.MERGE,
			fetch = FetchType.LAZY)
	@JoinColumn(name = "carId")
	private Car cars;
	
	@ManyToOne(cascade = CascadeType.MERGE,
			fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId")
	private Customer customers;

	public Rentals() {
		super();
	}

	public Rentals(Integer rentalId, String rentDate, String timeDepart, String timeArrive, String returnDate,
			double rentFee, Car cars, Customer customers) {
		super();
		this.rentalId = rentalId;
		this.rentDate = rentDate;
		this.timeDepart = timeDepart;
		this.timeArrive = timeArrive;
		this.returnDate = returnDate;
		this.rentFee = rentFee;
		this.cars = cars;
		this.customers = customers;
	}

	public Integer getRentalId() {
		return rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getTimeDepart() {
		return timeDepart;
	}

	public void setTimeDepart(String timeDepart) {
		this.timeDepart = timeDepart;
	}

	public String getTimeArrive() {
		return timeArrive;
	}

	public void setTimeArrive(String timeArrive) {
		this.timeArrive = timeArrive;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public double getRentFee() {
		return rentFee;
	}

	public void setRentFee(double rentFee) {
		this.rentFee = rentFee;
	}

	public Car getCars() {
		return cars;
	}

	public void setCars(Car cars) {
		this.cars = cars;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Rentals [rentalId=" + rentalId + ", rentDate=" + rentDate + ", timeDepart=" + timeDepart
				+ ", timeArrive=" + timeArrive + ", returnDate=" + returnDate + ", rentFee=" + rentFee + ", cars="
				+ cars + ", customers=" + customers + "]";
	}

	
}
