package com.edubridge.app1.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.app1.dao.CustomerDao;
import com.edubridge.app1.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	
	public Customer saveCustomer(Customer c) {
		return dao.saveCustomer(c);
	}

	public List<Customer> getCustomer(){
		 return dao.getCustomers();
	}
	
	public Customer getCustomer(Integer customerId) {
		return dao.getCustomer(customerId);
	}
	
	public void updateCustomer(Customer c) {
		dao.updateCustomer(c);
	}
	
	public void deleteCustomer(Integer customerId) {
		dao.deleteCustomer(customerId);
	}
	
	public Customer login(Integer customerId,String password) throws Exception{
		Customer customer=dao.getCustomer(customerId);
		System.out.println(customer.getPassword());
		if(customer.getCustomerId().equals(customerId) && customer.getPassword().equals(password)) {
			return customer;
		}else {
			throw new Exception("invalid Credentials");
		}
		
	}

}
