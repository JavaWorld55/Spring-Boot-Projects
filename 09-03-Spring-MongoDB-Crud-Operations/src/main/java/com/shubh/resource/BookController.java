package com.shubh.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.model.Book;
import com.shubh.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepo;
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book) {
		bookRepo.save(book);
		return "book added successfully by id::"+book.getBookId();
		}
	
	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		
		return bookRepo.findAll();
		}
	@GetMapping("/getById/{id}")
	public Optional<Book> getBooksById(@PathVariable("id")int id) {
		
		return bookRepo.findById(id);
		}
	
	@DeleteMapping("/delete/{id}")
	public String removeBook(@PathVariable("id")int id) {
		bookRepo.deleteById(id);
		return "Remove book by id::"+ id;
	}

}
