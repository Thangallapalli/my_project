package com.edubridge.app1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.app1.dao.RentalDao;
import com.edubridge.app1.model.Rentals;

@Service
public class RentalService {
	@Autowired
	private RentalDao dao;
	

	public Rentals saveBookingRecord(Rentals b) {
		return dao.saveBookingRecord(b);
	}
	
	public List<Rentals> getBookingRecords(){
		return dao.getBookingRecords();
	}
	
	public Rentals getBookingRecord(Integer bookingId) {
		return dao.getBookingRecord(bookingId);
	}
	
	public void updateBookingRecord(Rentals b) {
		dao.updateBookingRecord(b);
	}
	
	public void deleteBookingRecord(Integer bookingId) {
		dao.deleteBookingRecord(bookingId);
	}

}
