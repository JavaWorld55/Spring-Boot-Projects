package com.shubh.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OtpSystem {
	
	private String mobileNumber;
	private String otp;
	private long expiryDate;

}
