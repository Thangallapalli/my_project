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

import com.edubridge.app1.model.Customer;
import com.edubridge.app1.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@PostMapping("/customer")
	public ResponseEntity<Customer> save(@RequestBody Customer customer) {
		Customer savedCustomer = service.saveCustomer(customer);
		return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> customers = service.getCustomer();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getOneCustomer(@PathVariable("id") Integer customerId) {
		Customer customer = service.getCustomer(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer customerId) {
		service.deleteCustomer(customerId);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}

	@PutMapping("/customer")
	public ResponseEntity<Customer> updte(@RequestBody Customer customer) {
		service.saveCustomer(customer);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("customer/valid")
	public Customer login(@RequestBody Customer customer) throws Exception{
		return this.service.login(customer.getCustomerId(), customer.getPassword());
	}

}
