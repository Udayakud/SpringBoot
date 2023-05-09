package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class RestService {

	public String giveSwap(int a,int b) {
		int temp=b;
	    b=a;
	    a=temp;
		return "Swapped values"+b+"  "+a;
	}


}
