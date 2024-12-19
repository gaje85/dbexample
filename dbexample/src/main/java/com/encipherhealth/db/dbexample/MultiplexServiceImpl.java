package com.encipherhealth.db.dbexample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MultiplexServiceImpl {

	@Autowired
	MultiplexRepository multiplexRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	SnacksRepository snacksRepository;

	public MultiplexServiceImpl() {

	}

	public List<Movies> listMovies() {
		List<Movies> movieList = new ArrayList<Movies>();

		Movies movie = new Movies();
		movie.setLanguage("Tamil");
		// movie.setMovieId(1);
		movie.setName("Enthiran");
		movieList.add(movie);

		movie = new Movies();
		movie.setLanguage("English");
		// movie.setMovieId(2);
		movie.setName("InterStaller");
		movieList.add(movie);
		List<Movies> savedMoviesList = (List<Movies>) multiplexRepository.saveAll(movieList);
		return savedMoviesList;

	}

	public Booking createBooking(Movies movies) {

		Booking booking = new Booking();
		// booking.setBookingId(1);
		booking.setMovieId(movies.getMovieId());
		booking.setPrice(200);
		bookingRepository.save(booking);
		return booking;
	}

	public List<Snacks> createSnacks(int bookingId, List<Snacks> snacksList) {

		snacksList.forEach((snacks) -> {
			snacks.setBookingId(bookingId);
		});

		return (List<Snacks>) snacksRepository.saveAll(snacksList);

	}

	public Snacks updateSnacks(int bookingId, int snacksId) {

		Snacks snacks = snacksRepository.findByBookingIdAndId(bookingId, snacksId);
		snacks.setPrice(7.99);
		return snacks;
	}
	
	
	public boolean deleteBooking(int bookingId) {
		bookingRepository.deleteById(bookingId);
		snacksRepository.deleteAllByBookingId(bookingId);
		
		return true;
	}
		
		
}
