package com.shubh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shubh.domain.OrderResponse;
import com.shubh.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	@Query("SELECT new com.shubh.domain.OrderResponse(c.customerName , p.productName) from Customer c JOIN c.prodList p")
	public List<OrderResponse> fetchCustomerInfo();
}
