package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookServices {
	
	@Autowired
	private BookRepository bookRepository;
	
	//private static List<Book> list = new ArrayList<>();
	
//	static
//	{
//		list.add(new Book(12,"Java Complete Reference","XYZ"));
//		list.add(new Book(36,"Head First to java","ABC"));
//		list.add(new Book(65, "Think in java", "JKL"));
//	}
	
	//get all books
	public List<Book> getAllBooks()
	{
		List<Book> list =(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	// get single book by id
	public Book getBookById(int id)
	{
		Book book = null;
		try 
		{
		    //	book = list.stream().filter(e->e.getId()==id).findFirst().get();
			this.bookRepository.findById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return book;
	}
	
	//add book...
	public Book addBook(Book b)
	{
	//	list.add(b);
		Book result=bookRepository.save(b);
		
		return result;
	}
	
	
	public void deleteBook(int bid)
	{
		//list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
	    bookRepository.deleteById(bid);
	}
	
	
	
	public void updateBook(Book book, int bookId)
	{
//		list = list.stream().map(b->{
//			if(b.getId()==bookId)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(bookId);
		bookRepository.save(book);
	}
	
	
}
