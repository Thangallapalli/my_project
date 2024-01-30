package com.edubridge.app1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.app1.model.Customer;
import com.edubridge.app1.repo.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository repo;
	

	public Customer saveCustomer(Customer c) {
		return repo.save(c);
	}

	public List<Customer> getCustomers(){
		 return repo.findAll();
	}
	
	public Customer getCustomer(Integer customerId) {
		return repo.findById(customerId).get();
	}
	
	public void updateCustomer(Customer c) {
		repo.save(c);
	}
	
	public void deleteCustomer(Integer customerId) {
		repo.deleteById(customerId);
	}


}
