package com.shubh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.dao.LibraryDAO;
import com.shubh.model.Library;

@RestController
public class LibraryController {
	
	@Autowired
	private LibraryDAO dao;
	
	@PostMapping("/saveBook")
	public String saveBooks(@RequestBody Library lib) {
		
		String msg = dao.saveObject(lib);
		
		return msg;
	}
	
	@GetMapping("/getBook/{libId}")
	public Library getBooks(@PathVariable("libId") int libId) {
		
		Library saveObject = dao.getObject(libId);
		
		return saveObject;
	}

}
