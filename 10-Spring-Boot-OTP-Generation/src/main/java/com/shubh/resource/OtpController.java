package com.shubh.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.model.OtpSystem;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class OtpController {
	
	private final static String ACCOUNT_SID="AC71b4afa798dc3d0199f30bfa3565e376";
	private final static String AUTH_ID="ac388c52b00afc6e41a4f632fa28fd42";
	Map<String,OtpSystem> otpData=new HashMap<>();
	
	static {
		
		Twilio.init(ACCOUNT_SID,AUTH_ID );
	}
	
	@PostMapping("number/{mobileNumber}/otp")
	public ResponseEntity<Object> sendOpt(@PathVariable("mobileNumber") String mobileNumber) {
		
		
		OtpSystem otp=new OtpSystem();
		  otp.setMobileNumber(mobileNumber);
		  otp.setOtp(String.valueOf((int)Math.random()*(10000-1000)-1000));
		  otp.setExpiryDate(System.currentTimeMillis()+20000);
		  
		  otpData.put(mobileNumber, otp);
		  
		  Message.creator(new PhoneNumber("+917566373532"),new PhoneNumber("+14807252747"),"This is your otp::"+otp.getOtp()).create();
		  
		  return new ResponseEntity<>("Your Otp is send successfully",HttpStatus.OK);
	}
	
	@PutMapping("number/{mobileNumber}/otp")
	public ResponseEntity<Object> getOtp(@PathVariable("mobileNumber") String number,@RequestBody OtpSystem requestBodyOtpSystem){
		
		if(requestBodyOtpSystem.getOtp()==null||requestBodyOtpSystem.getOtp().trim().length()<=0) {
			
			return new ResponseEntity<>("Please provide otp",HttpStatus.BAD_REQUEST);
		}
		
		if(otpData.containsKey(number)) {
			
			OtpSystem otp=otpData.get(number);
			
			if(otp!=null) {
			
			if(otp.getExpiryDate()>=System.currentTimeMillis()) {
				
			if(requestBodyOtpSystem.getOtp().equals(otp.getOtp())) {
				
				return new ResponseEntity<>("Your otp is valided successfully",HttpStatus.OK);
			}
				return new ResponseEntity<>("your otp is invalid",HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>("Your otp is expired",HttpStatus.BAD_REQUEST);
			
			}
			return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Mobile number is invalid",HttpStatus.NOT_FOUND);
		
	}
	
	
	
	

}
