package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.BookRepository;
import com.example.model.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
   //public static List<Book> list = new ArrayList<Book>();

	//static {
	//	list.add(new Book(12, "java Complete ref", "xyz"));
	//	list.add(new Book(32, "hiberante tuts", "aaa"));
	//	list.add(new Book(44, "spring boot", "dddd"));
	//}

	// get all books
	public List<Book> getAllBooks() {

	List<Book> list = (List<Book>)this.bookRepository.findAll();
	return list;
	}

	// get single book by id
	public Book getBookById(int id) {

	Book book = null;
		//book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		book = this.bookRepository.findById(id);
		
		return book;
	}

	// adding the book
	public Book addBook(Book b)
	{
		Book result = bookRepository.save(b);
		return result;
	}
	
	// deleting the book
	public void deleteBook(int id)
	{
	//list= list.stream().filter(book ->book.getId()!=id).
			//collect(Collectors.toList());	
		bookRepository.deleteById(id);
		
	}
	
	public void updateBook(Book book, int id) {
		book.setId(id);
		bookRepository.save(book);
		
	}
}
