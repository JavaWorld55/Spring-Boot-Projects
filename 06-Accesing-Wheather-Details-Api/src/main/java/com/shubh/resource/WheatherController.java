package com.shubh.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.client.AccessingWheatherReport;

@RestController
public class WheatherController {
	
	
	@GetMapping("/getWheather")
	public String getReport()
	{
		AccessingWheatherReport report =new AccessingWheatherReport();
	         
		 String Report = report.GetWheatherReport();
		 
		return Report;
		
	}
}
