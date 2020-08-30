package com.shubh.service;

import com.shubh.command.AadharDetails;
import com.shubh.command.AddressDetails;
import com.shubh.command.PersonDetails;
import com.shubh.entity.AadharDetailsEntity;
import com.shubh.entity.AddressDetailsEntity;

public interface PersonDetailsService {

	public PersonDetails savedPersonDetails(PersonDetails person);
	public AddressDetails savedAddressDetails(AddressDetails details,Integer pid);
	public PersonDetails getPersonById(Integer pid);
	public AddressDetailsEntity getAddressById(Integer aid);
    public AadharDetailsEntity savedAadharDetails(AadharDetails aadhar,Integer aid);
    public AadharDetailsEntity fetchAadharByNo(Long aadharNo);
}
