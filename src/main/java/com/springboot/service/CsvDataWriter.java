package com.springboot.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.pojo.Product;
@Component
public class CsvDataWriter {
	
	public String csvDataWriter(List<Product> product) throws IOException {
		
		FileWriter fw=new FileWriter("C:\\Users\\msk\\Desktop\\Test\\FilteredData.txt");
		System.out.println("Running write method.....");
		product.forEach(p->{
			try {
				fw.write(p.getPid()+", "+p.getPname()+", "+p.getPrice());
				fw.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		fw.close();
		return "Success";
		
	}

}
