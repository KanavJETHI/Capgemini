package com.springboot.Controller;

import org.springframework.data.repository.CrudRepository;



public interface MoviesRepository extends CrudRepository<Movies, String> {
	
}
