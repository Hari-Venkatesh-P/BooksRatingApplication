package com.hari.books.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;



@Getter
@Setter
@ToString
@Document(collection="bookdetail")
public class Books {
	
	@Id
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("rating")
	private String rating;
	
	@JsonProperty("author")
	private String author;
	
	
	public Books()
	{
		
	}
	
	public Books(int id, String title, String rating, String author) {
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
