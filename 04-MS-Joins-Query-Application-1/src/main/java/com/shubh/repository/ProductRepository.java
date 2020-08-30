package com.shubh.repository;

import org.springframework.data.repository.CrudRepository;

import com.shubh.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
