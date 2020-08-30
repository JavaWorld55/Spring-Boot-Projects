package com.shubh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shubh.command.AadharDetails;
import com.shubh.command.AddressDetails;
import com.shubh.command.PersonDetails;
import com.shubh.entity.AadharDetailsEntity;
import com.shubh.entity.AddressDetailsEntity;
import com.shubh.entity.PersonDetailsEntity;
import com.shubh.service.PersonDetailsService;
import com.shubh.utils.AadharUtils;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private PersonDetailsService service;
	@InitBinder
	public void init(WebDataBinder binder) {
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
	binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf, true));
	}

	@GetMapping("/userForm")
	public String loadUserDetails(@ModelAttribute("userDetails") PersonDetails user) {
		
		return "user_details";
	}
	@GetMapping("/addressForm")
	public String loadAddressDetails(@ModelAttribute("addressDetails") AddressDetails address,HttpSession ses,Model model) {
		Integer pid = (Integer) ses.getAttribute("pid");
		model.addAttribute("personId",pid);
		return "user_address";
	}
	@GetMapping("/aadharForm")
	public String loadAadharForm(@ModelAttribute("aadhar") AadharDetails aadhar) {
		
		return "get_aadhar_details";
	}
	
	@PostMapping("/saveUser")
	public String savePersonDetails(@ModelAttribute("userDetails") PersonDetails user,Model model,HttpSession ses) {
		      
		      PersonDetails details = service.savedPersonDetails(user);
		      ses.setAttribute("person", details);

		      if(details!=null) {
		    	  ses.setAttribute("pid", details.getPersonId());

		      model.addAttribute("msg", details);
		      }
		      else
			      model.addAttribute("msg","record not save");

		      return "redirect:/addressForm";
		    
	}
	@GetMapping("/editForm")
	public String getContactByEditButton(HttpServletRequest req,Model model) {
	    
		int pid = Integer.parseInt(req.getParameter("pid"));
		PersonDetails user = service.getPersonById(pid);
	
		model.addAttribute("userDetails", user);
		
		return "user_details";
	}
	
	@PostMapping("/saveAddress")
	public String saveAddressDetails(@ModelAttribute("addressDetails") AddressDetails details,HttpSession ses,Model model,Map<String,Object> map) {
		   Integer pid=(int)ses.getAttribute("pid"); 
		      details = service.savedAddressDetails(details,pid);
		PersonDetails person = service.getPersonById(pid); 
		if(details!=null) {
			model.addAttribute("address", details);
		    map.put("details", person);
		      ses.setAttribute("aid", details.getAddressId());
		}
		else
			model.addAttribute("msg", details);
		
		return "confirmation_page";
	}
	
	@GetMapping("/saveAadhar")
	public String saveAadharDetails(AadharDetails aadhar,HttpSession ses,Model model) {
		Integer aid= (Integer) ses.getAttribute("aid");
		Long aadharNo =Long.parseLong(AadharUtils.randomAlphaNumeric(12));
		aadhar.setAadharNo(aadharNo);
		AadharDetailsEntity aadharDetails = service.savedAadharDetails(aadhar,aid);
		model.addAttribute("aadhar", aadharDetails);
		
		return "success_page";
	}
	
	@PostMapping("/getAadhar")
	public String getAadharByNo(@ModelAttribute("aadhar") AadharDetails aadhar,Map<String,Object> map) {
		
		    Long aadharNo = aadhar.getAadharNo();
		    AadharDetailsEntity aadharByNo = service.fetchAadharByNo(aadharNo);
		    AddressDetailsEntity addressDetails = aadharByNo.getAddressDetails();
		       PersonDetailsEntity personDetails = addressDetails.getPersonAddress();
		       
		    map.put("aadhar", aadharByNo);
		    map.put("address", addressDetails);
		    map.put("person", personDetails);
		    
		return "aadhar_details";
	}

}
