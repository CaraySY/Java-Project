package com.wsy.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMatch {

	public static void main(String[] args) {
		
		Integer[] array=new Integer[] {1,2,3,4,5,6,7};
		Stream<Integer> stream = Arrays.stream(array);
		//boolean flag = stream.allMatch(i->i > 3);
		//System.out.println("all number over 3:"+flag);
		boolean flag=stream.anyMatch(i->i > 5);
		System.out.println("any number over 5:"+flag);
	}
}
