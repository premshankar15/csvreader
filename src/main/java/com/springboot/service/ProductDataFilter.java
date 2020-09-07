package com.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.pojo.Product;

@Component
public class ProductDataFilter {
	
	public List<Product> productDataFilter(List<Product> fproduct){
		//List<Product> filterdataList=new ArrayList<>();
		List<Product> collect = fproduct.stream()
				                .filter(p->p.getPrice()>=300.00)
				                .collect(Collectors.toList());
		return collect;
		
		
	}

}
