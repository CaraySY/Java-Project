package com.wsy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,3,3,4,5);
		//List<Integer> res = list.stream().filter(i->i%2==0).collect(Collectors.toList());
		List<Integer> res = list.stream().distinct().collect(Collectors.toList());
		res.stream().forEach(System.out::println);
	}
}
