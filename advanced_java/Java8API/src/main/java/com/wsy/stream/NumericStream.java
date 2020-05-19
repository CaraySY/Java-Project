package com.wsy.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStream {

	public static void main(String[] args) {
		
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7);
		Integer res = stream.filter(i->i>3).reduce(0,Integer::sum);
		System.out.println(res);
		stream = Stream.of(1,2,3,4,5,6,7);
		// return original data type
		IntStream toInt = stream.mapToInt(i->i.intValue());
		int sum = toInt.filter(i->i > 3).sum();
		System.out.println(sum);
	}
	
	public void getRealRes() {
		
		
	}
}
