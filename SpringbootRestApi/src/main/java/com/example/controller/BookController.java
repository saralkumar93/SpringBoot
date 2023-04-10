package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//@RequestMapping(value="/books",method=RequestMethod.GET)
	@GetMapping("/getallbook")
	public List<Book> getBook() {
		
//		Book book = new Book();
//		book.setId(11);
//		book.setTitle("java comple refe");
//		book.setAuthor("abc");
//		
		return this.bookService.getAllBooks();
	}
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		
		return bookService.getBookById(id);
	}
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		Book b =this.bookService.addBook(book);
       return b;	
	}
	
	// delete book handler
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		this.bookService.deleteBook(id);
		
	}

}
