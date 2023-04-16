package com.example.demo.processer;

import org.springframework.batch.item.ItemProcessor;

public class ArrayProcesser implements ItemProcessor<String,String>{

	@Override
	public String process(String item) throws Exception {
		// TODO Auto-generated method stub
		return item.toUpperCase();
	}

}
