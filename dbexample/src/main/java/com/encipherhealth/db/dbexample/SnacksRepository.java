package com.encipherhealth.db.dbexample;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SnacksRepository  extends CrudRepository<Snacks, Integer> {

	//@Query()
	public Snacks findByBookingIdAndId(int bookingId, int id);
	
	public void deleteAllByBookingId(int bookingId);
}
