package com.wsy.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamReduce {

	public static void main(String[] args) {
		
		Integer[] array=new Integer[] {1,2,3,4,5,6,7};
		Stream<Integer> stream = Arrays.stream(array);
		// reduce
		Integer res = stream.reduce(0, (i,j)->i+j);
		System.out.println(res);
		array=new Integer[] {1,2,3,4,5,6,7};
		stream = Arrays.stream(array);
		res=stream.reduce(0,Integer::sum);
		System.out.println(res);
	}
}
