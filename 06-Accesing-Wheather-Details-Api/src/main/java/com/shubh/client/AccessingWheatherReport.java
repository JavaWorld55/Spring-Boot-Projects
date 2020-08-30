package com.shubh.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AccessingWheatherReport {
	
	
	public String GetWheatherReport() {
		 
		//String access_key="b691a82c0f928f9d5eb6d6fae28e2757";
		String url="http://api.weatherstack.com/current?access_key=b691a82c0f928f9d5eb6d6fae28e2757&query=Paris";
		RestTemplate rt=new RestTemplate();
		
		ResponseEntity<String> responseEntity = rt.getForEntity(url, String.class);
		
		int statusCode = responseEntity.getStatusCodeValue();
		
		if(statusCode==200) {
			String body = responseEntity.getBody();
			return body;
		}
		else
			return null;
	}

}
