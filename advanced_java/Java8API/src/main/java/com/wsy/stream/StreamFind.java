package com.wsy.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFind {

	public static void main(String[] args) {
		
		Integer[] array=new Integer[] {1,2,3,4,5,6,7,8,10};
		Stream<Integer> stream = Arrays.stream(array);
		Optional<Integer> findAny = stream.filter(i->i>100).findAny();
		System.out.println("findAny->"+findAny.orElse(-1));
		array=new Integer[] {1,2,3,4,5,6,7};
		Stream<Integer> stream2 = Arrays.stream(array);
		Optional<Integer> findFirst = stream2.findFirst();
		System.out.println("findAny2->"+findFirst.get());
	}
}
