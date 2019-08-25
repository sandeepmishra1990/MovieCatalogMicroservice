package com.sandeep.MovieCatalog.bean;


public class Movie {
	
	private String name;
	private String description;
	private Long id;
	
	public Movie()
	{
		
	}
	
	public Movie(Long id, String name, String desc) {
		this.name=name;
		this.description=desc;
		this.id= id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}
