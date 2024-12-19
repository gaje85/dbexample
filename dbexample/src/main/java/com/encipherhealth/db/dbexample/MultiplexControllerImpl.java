package com.encipherhealth.db.dbexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiplexControllerImpl {
	
	@Autowired
	MultiplexServiceImpl multiplexServiceImpl;
	
	
	public MultiplexControllerImpl() {
		
	}
	
	@GetMapping("/multiplex")
	public List<Movies> listMovies() {
		return multiplexServiceImpl.listMovies();
		
	}
	@PostMapping("/multiplex")
	public Booking createBooking(@RequestBody Movies movies) {
	
		
		return multiplexServiceImpl.createBooking(movies);
	}
	
	@PostMapping("/multiplex/{bookingid}/snacks")
	public List<Snacks> createSnacks(@PathVariable("bookingid") int bookingId
			,@RequestBody List<Snacks> snacks) {
	
		
		return multiplexServiceImpl.createSnacks(bookingId, snacks);
	}
	
	@PutMapping("/multiplex/{bookingid}/snacks/{snacksid}")
	public Snacks updateSnacks(@PathVariable("bookingid") int bookingId
			,@PathVariable("snacksid") int snacksId) {
		return multiplexServiceImpl.updateSnacks(bookingId, snacksId);
	}
	@DeleteMapping("/multiplex/{bookingid}") 
   public boolean deleteBooking(@PathVariable("bookingid") int bookingId) {
		return multiplexServiceImpl.deleteBooking(bookingId);
	}
}
