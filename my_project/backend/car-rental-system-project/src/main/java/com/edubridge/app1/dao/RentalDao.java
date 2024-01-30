package com.edubridge.app1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.app1.model.Rentals;
import com.edubridge.app1.repo.RentalRepository;

@Repository
public class RentalDao {
	
	@Autowired
	private RentalRepository repo;
	
	public Rentals saveBookingRecord(Rentals b) {
		return repo.save(b);
	}
	
	public List<Rentals> getBookingRecords(){
		return repo.findAll();
	}
	
	public Rentals getBookingRecord(Integer bookingId) {
		return repo.findById(bookingId).get();
	}
	
	public void updateBookingRecord(Rentals b) {
		repo.save(b);
	}
	
	public void deleteBookingRecord(Integer bookingId) {
		repo.deleteById(bookingId);
	}


}
