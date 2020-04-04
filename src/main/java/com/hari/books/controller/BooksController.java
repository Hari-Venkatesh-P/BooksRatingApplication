package com.hari.books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hari.books.model.ApiResponse;
import com.hari.books.model.Books;
import com.hari.books.service.BooksService;

@RestController
public class BooksController {

	@Autowired BooksService booksService;
	
	@RequestMapping(path="/getbookbyid/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Optional<Books> getBookById(@PathVariable("id") int id)
	{
		return booksService.getBookbyId(id);
	}
	
	@RequestMapping(path="/addbook", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse addBook(@RequestBody Books books)
	{
		return booksService.addBook(books);
	}
	
	@RequestMapping(path="/deletebookbyid/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse deleteBookbyId(@PathVariable("id") int id)
	{
		return booksService.deleteBookbyId(id);
	}
	
	@RequestMapping(path="/getallbooks", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Books> getAllBooks()
	{
		return booksService.getAllBooks();
	}
	
	@RequestMapping(path="/updaterating/{id}/{rating}",  method=RequestMethod.PUT , produces=MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse updateRating(@PathVariable("id") int id,@PathVariable("rating") String rating)
	{
		return booksService.updateRating(id,rating);
	}
	
}
