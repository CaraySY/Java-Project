package com.wsy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.wsy.bean.Dish;

/**
 * 	How to use the stream to reduce step of collection
 * @author Administrator
 *
 */
public class SimpleStream {

	public static void main(String[] args) {
		
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
		
		/*List<String> res = menu.stream().filter(dish->dish.getCalories()<400)
				.sorted(Comparator.comparing(Dish::getCalories)).map(dish->dish.getName())
				.collect(Collectors.toList());
		res.stream().forEach(System.out::println);*/
		List<String> res = menu.stream().filter(dish->{
			System.out.println("filtering]->"+dish.getName());
			return dish.getCalories()>400;
		}).map(dish->{
			System.out.println("mapping]->"+dish.getName());
			return dish.getName();
		}).limit(3).collect(Collectors.toList());
		res.stream().forEach(s->System.out.println(s));
	}
}
