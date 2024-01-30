package com.edubridge.app1.model;


import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CustomerLogin_details")
public class Customer {

	@Id
	@GeneratedValue
	private Integer customerId;
	private String customerName;
	private String password;
	private String gender;
	private String customerEmail;
	private Long mobileNumber;

	

	public Customer() {
		super();
	}

	public Customer(Integer customerId, String customerName, String password, String gender, String customerEmail,
			Long mobileNumber, Set<Rentals> rentals) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.gender = gender;
		this.customerEmail = customerEmail;
		this.mobileNumber = mobileNumber;
	//	this.rentals = rentals;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/*public Set<Rentals> getRentals() {
		return rentals;
	}

	public void setRentals(Set<Rentals> rentals) {
		this.rentals = rentals;
	}*/

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", gender=" + gender + ", customerEmail=" + customerEmail + ", mobileNumber=" + mobileNumber
				+ "]";
	}

	
}