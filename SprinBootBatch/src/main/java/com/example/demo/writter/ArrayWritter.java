package com.example.demo.writter;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class ArrayWritter implements ItemWriter<String>{

	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		// TODO Auto-generated method stub
		for(String s:chunk) {
			System.out.println(s);
		}
		
		System.out.println("---");
	}

}
