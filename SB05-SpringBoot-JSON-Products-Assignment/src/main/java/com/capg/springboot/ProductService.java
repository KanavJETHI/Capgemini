package com.capg.springboot;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
	public List products = Arrays.asList(
			new ProductBean(1, "P1", "Good Product"),
			new ProductBean(2, "P2", "Good Product"),
			new ProductBean(3, "P3", "Bad Product"),
			new ProductBean(4, "P4", "Bad Product")
			);
	
	public List<ProductBean> getAllProducts(){
		return products;
	}
	
	
}
