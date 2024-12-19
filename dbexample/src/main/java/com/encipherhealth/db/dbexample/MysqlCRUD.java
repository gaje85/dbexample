package com.encipherhealth.db.dbexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RestController
@Transactional
public class MysqlCRUD {

	@Autowired
	CustomerRepository repo;
	
	@Autowired
	EntityManager manager;
	
	public MysqlCRUD() {
		
	}
	
	@GetMapping("/crud")
	public void crudDB() {
		// Create a Record;
		Customer customer = new Customer();
		customer.setAddress("vadapalani");
		customer.setEmail("test@test.com");
		customer.setName("John");
		customer.setAge(30);
		
		Customer savedCustomer = repo.save(customer);
		// update a record
		savedCustomer.setAge(60);
		manager.flush();
		System.out.println(savedCustomer.getAge());
		repo.delete(savedCustomer);
		
	}
}
