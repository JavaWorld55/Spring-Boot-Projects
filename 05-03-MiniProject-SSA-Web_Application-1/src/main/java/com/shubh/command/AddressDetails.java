package com.shubh.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressDetails {
	
	private int addressId;
	private String address1;
	private String address2;
	private String state;
	private String city;
	private int pincode;
	private PersonDetails personAddress;

}
