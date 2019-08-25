package com.sandeep.MovieCatalog.bean;

public class MovieCatalog {
	
	private String name;
	private String desc;
	private int rating;
	
	public MovieCatalog(String name, String description, int rating) {
		this.name=name;
		this.desc=description;
		this.rating=rating;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
