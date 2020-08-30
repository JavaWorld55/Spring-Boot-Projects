package com.shubh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.domain.OrderPlace;
import com.shubh.domain.OrderResponse;
import com.shubh.entity.Customer;
import com.shubh.repository.CustomerRepository;
import com.shubh.repository.ProductRepository;

@RestController
public class OrderController {
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@PostMapping(value="/placeOrder",
			consumes="application/json")
	public Customer placeOrder(@RequestBody OrderPlace place) {

		return custRepo.save(place.getCust());
		 
		}
	
	@GetMapping("/getOrder/{cid}")
	public Customer getOrderDetails(@PathVariable("cid") Integer cid) {
		
		      Optional<Customer> findById = custRepo.findById(cid);
		      return findById.get();
	}
	
	@GetMapping("/getInfo")
	public List<OrderResponse> getCustomerInfo() {
	 return custRepo.fetchCustomerInfo();
	
	}
}
