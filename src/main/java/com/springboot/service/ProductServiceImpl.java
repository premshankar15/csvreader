package com.springboot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.pojo.Product;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private CsvDataReader dataReader;
	
	@Autowired
	private CsvDataWriter csvDataWriter;
	
    @Autowired
    private ProductDataFilter productDataFilter;
    
    String csvDataWriter2;

	@Override
	public String doProcess(String fileName) {
	try {
		List<Product> csvDataReader = dataReader.csvDataReader(fileName);
		List<Product> productDataFilter2 = productDataFilter.productDataFilter(csvDataReader);
		csvDataWriter2 = csvDataWriter.csvDataWriter(productDataFilter2);
		
	
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("IO Exception thrown");
	}
	return csvDataWriter2;
	}

}
