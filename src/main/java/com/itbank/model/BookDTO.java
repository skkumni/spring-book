package com.itbank.model;

import java.sql.Date;

//	IDX         NOT NULL NUMBER        
//	NAME        NOT NULL VARCHAR2(100) 
//	PUBLISHER   NOT NULL VARCHAR2(50)  
//	PUBLISHDATE          DATE          
//	PRICE                NUMBER   

public class BookDTO {

	private int idx;
	private String name;
	private String publisher;
	private Date publishDate;
	private int price;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
