package com.capg.springboot;
import java.io.Serializable;

public class ProductBean  implements Serializable{
 	private int productId;
 	private String name;
 	private String description;
 	
	public ProductBean(int productId, String name, String description) {
		
		this.productId = productId;
		this.name = name;
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	
 	
 	
 	
 	
 	
 	
 	
}
