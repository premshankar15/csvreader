package com.springboot.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.pojo.Product;

@Component
public class CsvDataReader {

	List<Product> dataList=new ArrayList<>();
	
	public List<Product> csvDataReader(String fileName) throws IOException{
		
		FileReader fileReader=new FileReader(fileName);
		BufferedReader bufferReader=new BufferedReader(fileReader);
		String productData= bufferReader.readLine();
		
		while(productData!=null) {
			String arr[]=productData.split(" ");
			String productId=arr[0];
			String productName=arr[1];
			String productPrice=arr[2];
			
			Product p=new Product();
			p.setPid(Integer.parseInt(productId));
			p.setPname(productName);
			p.setPrice(Double.parseDouble(productPrice));
			dataList.add(p);
			productData= bufferReader.readLine();
			
		}
		bufferReader.close();
		return dataList;
		
	}
}
