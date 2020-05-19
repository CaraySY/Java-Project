package com.wsy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wsy.bean.Dish;

public class StreamMap {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,3,3,4,5);
		List<String> res = list.stream().map(n->n+"->hello").collect(Collectors.toList());
		res.stream().forEach(System.out::println);
		System.out.println("=======================");
		List<Dish> menu=getDishs();
		menu.stream().map(Dish::getName).forEach(System.out::println);
		String[] words= {"Hello","World"};
		// split to {{H,e,l,l,o},{W,o,r,l,d}}
		Stream<String[]> stream=Arrays.stream(words).map(w->w.split(""));
		// use flapMap to flatten stream
		// combined to {H,e,l,l,o,W,o,r,l,d}
		Stream<String> strStream=stream.flatMap(Arrays::stream);
		strStream.distinct().forEach(System.out::println);
	}
	
	private static List<Dish> getDishs(){
		
		List<Dish> menu = Arrays.asList(
			    new Dish("pork", false, 800, Dish.Type.MEAT),
			    new Dish("beef", false, 700, Dish.Type.MEAT),
			    new Dish("chicken", false, 400, Dish.Type.MEAT),
			    new Dish("french fries", true, 530, Dish.Type.OTHER),
			    new Dish("rice", true, 350, Dish.Type.OTHER),
			    new Dish("season fruit", true, 120, Dish.Type.OTHER),
			    new Dish("pizza", true, 550, Dish.Type.OTHER),
			    new Dish("prawns", false, 300, Dish.Type.FISH),
			    new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		return menu;
	}
}
