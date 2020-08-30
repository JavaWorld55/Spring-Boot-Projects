package com.shubh.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.shubh.model.Library;

@Repository
//@Transactional
public class LibraryDAO {
	
	@Autowired
	private SessionFactory factory;
	
	public LibraryDAO() {
    System.out.println("DAO class object");
	}
	//Transaction tx=null;
	public Session getSession() {
		
		Session sess = factory.getCurrentSession();
		if(sess!=null) {
			sess=factory.openSession();
		}
		return sess;
	}
	
	@Transactional
	public Library getObject(int libId) {
		
		Library library = getSession().get(Library.class,libId);
		if(library!=null) {
			 
		return library;
		}
		else {
	
			return null;
		}
	}
	@Transactional
	//@Modifying
	public String saveObject(Library  lib) {
		
		Serializable  id = getSession().save(lib);
		if(id!=null) {
			 
		return "Book is stored";
		}
		else {
	
			return "Book is not saved";
		}
	}

}
