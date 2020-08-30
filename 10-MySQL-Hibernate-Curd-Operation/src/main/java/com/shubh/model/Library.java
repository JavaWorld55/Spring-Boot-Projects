package com.shubh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="library")
@ToString
public class Library {
	
	@Id
	//@GenericGenerator(name="gen",strategy="increment")
	//@GeneratedValue(generator="gen")
	@Column(name="lib_id")
	private int libId;
	@Column(name="book_name")
	private String bookName;
	@Column(name="price")
	private int price;

}
