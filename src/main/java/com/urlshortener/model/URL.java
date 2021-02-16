package com.urlshortener.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "URL")
public class URL {
    
	 @Column(name = "originalURL")
	 private String originalURL;
	 
	 
	 public URL(String originalURL, String shortURL, int id, int counter) {
		super();
		this.originalURL = originalURL;
		this.shortURL = shortURL;
		this.id = id;
		this.counter = counter;
	}
	 
	 public URL()
	    {
	     super();
	    }
	@Column(name = "shortURL")
	 private String shortURL;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private int id;
	 
	 @Column(name = "counter")
	 private int counter;
	 
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getOriginalURL() {
		return originalURL;
	}
	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}
	public String getShortURL() {
		return shortURL;
	}
	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
