package com.sandeep.MovieCatalog.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sandeep.MovieCatalog.bean.Movie;
import com.sandeep.MovieCatalog.bean.MovieInfo;

@Service
public class MovieCatalogService {
	
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * Hystrixcommand used for fault-tolerence and making app more resilient
	 * Also u have to enable circuit-breaker on controller
	 * this hystrix implements circuit-breaker pattern
	 * When microservice stops responding or get's slow because of huge request
	 * it breaks the circuit based on hystrixcommand parameters(not implemented here)
	 * so certain time so that app can recover
	 * @return
	 */
	@HystrixCommand(fallbackMethod="getMovieInfoListFallback")
	public MovieInfo getMovieInfoList(){
		return restTemplate.getForObject("http://movieinfo-microservice.herokuapp.com/movieinfo/1234", MovieInfo.class);
	
	}
	
	public MovieInfo getMovieInfoListFallback()
	{
		System.out.println("this is fallback method, the original service is down");
		MovieInfo mi= new MovieInfo();
		mi.setMovieInfoList(new ArrayList<Movie>());
		return mi;
	}
}
