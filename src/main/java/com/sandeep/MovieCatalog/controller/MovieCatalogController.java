package com.sandeep.MovieCatalog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sandeep.MovieCatalog.bean.Movie;
import com.sandeep.MovieCatalog.bean.MovieCatalog;
import com.sandeep.MovieCatalog.bean.MovieInfo;
import com.sandeep.MovieCatalog.bean.ResponseWrapper;
import com.sandeep.MovieCatalog.services.MovieCatalogService;

@RestController
@EnableCircuitBreaker
@RequestMapping(value = "/catalog")
public class MovieCatalogController {

	@Autowired
	MovieCatalogService service;

	@GetMapping(value="/")
	public ResponseWrapper getMovieInfo()
	{
		ResponseWrapper response=new ResponseWrapper();
		
		
		MovieInfo list= service.getMovieInfoList();
		
		List<MovieCatalog> catalogList=list.getMovieInfoList().stream().map(movie->
			new MovieCatalog(movie.getName(),movie.getDescription(),4)
		).collect(Collectors.toList());
		
	
		response.setMovieCatalogList(catalogList);
		
		return response;
	}

}
