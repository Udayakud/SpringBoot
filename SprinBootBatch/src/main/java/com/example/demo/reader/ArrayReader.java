package com.example.demo.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class ArrayReader implements ItemReader<String>{
	
	String message[]= {"hello","world","java"};
	int index;

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(index<message.length) {
			return message[index++];
		}else {
			index=0;
		}
		
		return null;
	}
	

}
