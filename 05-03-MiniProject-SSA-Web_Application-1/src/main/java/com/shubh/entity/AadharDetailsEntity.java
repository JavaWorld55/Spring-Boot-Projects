package com.shubh.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="aadhar_details")
public class AadharDetailsEntity {
	
	@Id
	@Column(name="aadhar_no")
	private Long aadharNo;
	@OneToOne(targetEntity=AddressDetailsEntity.class,cascade=CascadeType.ALL)
	@JoinColumn(name="address_id",referencedColumnName="address_id")
	private AddressDetailsEntity addressDetails;
	
	
	

}
