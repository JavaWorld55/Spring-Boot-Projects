package com.shubh.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubh.command.AadharDetails;
import com.shubh.command.AddressDetails;
import com.shubh.command.PersonDetails;
import com.shubh.entity.AadharDetailsEntity;
import com.shubh.entity.AddressDetailsEntity;
import com.shubh.entity.PersonDetailsEntity;
import com.shubh.repository.AadharDetailsRepository;
import com.shubh.repository.AddressDetailsRepository;
import com.shubh.repository.PersonDetailsRepository;
import com.shubh.utils.AadharUtils;

@Service
public class PersonDetailsServiceImpl implements PersonDetailsService {

	@Autowired
	private PersonDetailsRepository detailsRepo;
	@Autowired
	private AddressDetailsRepository addressRepo;
	@Autowired
	private AadharDetailsRepository aadharRepo;
	
	@Override
	public PersonDetails savedPersonDetails(PersonDetails person) {
        
	
		PersonDetailsEntity entity=new PersonDetailsEntity();
		BeanUtils.copyProperties(person, entity);
		PersonDetailsEntity save = detailsRepo.save(entity);
		if(save!=null) {
		PersonDetails p=new PersonDetails();
		BeanUtils.copyProperties(save, p);
		return p;
		}
		else
			return null;
	}

	@Override
	public PersonDetails getPersonById(Integer pid) {

		Optional<PersonDetailsEntity> findById = detailsRepo.findById(pid);
		PersonDetails user=new PersonDetails();
		if(findById!=null) {
			BeanUtils.copyProperties(findById.get(), user);
			return user;
		}
		else 
			return null;
		
	}

	@Override
	public AddressDetails savedAddressDetails(AddressDetails details,Integer pid) {
		PersonDetailsEntity pe=null;
		Optional<PersonDetailsEntity> findById = detailsRepo.findById(pid);
		if(findById!=null) 
			 pe = findById.get();
		
		AddressDetailsEntity entity=new AddressDetailsEntity();
		BeanUtils.copyProperties(details, entity);
		    entity.setPersonAddress(pe);
	       entity=addressRepo.save(entity);
	       AddressDetails addres=new AddressDetails();
	BeanUtils.copyProperties(entity, addres);
	return addres;
	}

	@Override
	public AddressDetailsEntity getAddressById(Integer aid) {

		Optional<AddressDetailsEntity> findById = addressRepo.findById(aid);
		
		AddressDetailsEntity entity = findById.get();
		return entity;
	}

	@Override
	public AadharDetailsEntity savedAadharDetails(AadharDetails aadhar,Integer aid) {
           
		   Optional<AddressDetailsEntity> findById = addressRepo.findById(aid);
		   AddressDetailsEntity addressDetails = findById.get();
		   AadharDetailsEntity entity=new AadharDetailsEntity();
		      BeanUtils.copyProperties(aadhar, entity);
		      entity.setAddressDetails(addressDetails);
		      AadharDetailsEntity save = aadharRepo.save(entity);
		return save;
	}

	@Override
	public AadharDetailsEntity fetchAadharByNo(Long aadharNo) {

		AadharDetailsEntity findByAadharNo = aadharRepo.findByAadharNo(aadharNo);
		return findByAadharNo;
	}

	
	

}
