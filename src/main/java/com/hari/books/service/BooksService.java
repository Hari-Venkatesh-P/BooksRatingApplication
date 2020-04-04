package com.hari.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hari.books.repo.BooksRepo;
import com.hari.books.model.ApiResponse;
import com.hari.books.model.Books;



@Service
public class BooksService {
	
	@Autowired BooksRepo booksRepo;
	
	
	@Autowired MongoTemplate mongoTemplate;
	
	public Optional<Books> getBookbyId(int id)
	{
		return booksRepo.findById(id);
	}

	public ApiResponse addBook(Books books) {
		try {
		if(booksRepo.existsById(books.getId())==false)
		{
			
			booksRepo.insert(books);
			return new ApiResponse("200","Book Saved Successfully"," ");
		}
		else
		{
			return new ApiResponse("201","Unable to save book"," ");
		}
		}catch(Exception ex)
		{
			return new ApiResponse("500","Server Problem",""+ex);
		}
	}
	
	
	public ApiResponse updateRating(int id,String rating) {
		try {
		if(booksRepo.existsById(id))
		{
			Query query = new Query();
	        query.addCriteria(Criteria.where("id").is(id));
	        Update update = new Update();
	        update.set("rating", rating);
	        mongoTemplate.findAndModify(query, update, Books.class);
			return new ApiResponse("200","Book updated Successfully"," ");
		}
		else
		{
			return new ApiResponse("201","No book found with id:"+id," ");
		}
		}catch(Exception ex)
		{
			return new ApiResponse("500","Server Problem",""+ex);
		}
	}

	public ApiResponse deleteBookbyId(int id) {
		try {
			if(booksRepo.existsById(id))
			{
				booksRepo.deleteById(id);
				return new ApiResponse("200","Book deleted Successfully"," ");
			}
			else
			{
				return new ApiResponse("201","No book found with id:"+id," ");
			}
			}catch(Exception ex)
			{
				return new ApiResponse("500","Server Problem",""+ex);
			}
	}

	public List<Books> getAllBooks() {
		return booksRepo.findAll();
	}

}
