package com.edubridge.app1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.app1.model.Rentals;
import com.edubridge.app1.service.RentalService;

@RestController
@RequestMapping("/api")
public class RentalController {
	
	@Autowired
	private RentalService service;
	
	@PostMapping("/bookingRecord")
	public ResponseEntity<Rentals> save(@RequestBody Rentals bookingRecord){
		Rentals savedBookingRecord = service.saveBookingRecord(bookingRecord);
		return new ResponseEntity<>(savedBookingRecord, HttpStatus.OK);
	}

	@GetMapping("/bookingRecords")
	public ResponseEntity<List<Rentals>> getAllbookingRecords(){
	    List<Rentals> bookingRecords =service.getBookingRecords();
	    return new ResponseEntity<>(bookingRecords, HttpStatus.OK);
	}
	
	@GetMapping("/bookingRecord/{id}")
	public ResponseEntity<Rentals> getOneBookingRecord(@PathVariable("id") Integer bookingId){
		Rentals bookingRecord = service.getBookingRecord(bookingId);
		return new ResponseEntity<Rentals>(bookingRecord, HttpStatus.OK);
	}
	
		@DeleteMapping("/bookingRecord/{id}")
		public ResponseEntity<Rentals> deleteBookingRecord(@PathVariable("id") Integer bookingId){
		    service.deleteBookingRecord(bookingId);
			return new ResponseEntity<Rentals>(HttpStatus.OK);
	}
		
		  @PutMapping("/bookingRecord")
			public ResponseEntity<Rentals> updte(@RequestBody Rentals bookingRecord){
				service.saveBookingRecord(bookingRecord);
				return new ResponseEntity<>(HttpStatus.OK);
	}




}
