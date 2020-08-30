package com.shubh.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Product")
@Data
public class Product {
	
	@Id
	private int productId;
	private String productName;
	private int price;
	
}
