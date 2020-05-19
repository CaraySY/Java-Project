package com.wsy.collector;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.wsy.bean.Dish;

public class CollectorsInActionThree {

	private static final List<Dish> menu = Arrays.asList(
		    new Dish("pork", false, 800, Dish.Type.MEAT),
		    new Dish("beef", false, 700, Dish.Type.MEAT),
		    new Dish("chicken", false, 400, Dish.Type.MEAT),
		    new Dish("french fries", true, 530, Dish.Type.OTHER),
		    new Dish("rice", true, 350, Dish.Type.OTHER),
		    new Dish("season fruit", true, 120, Dish.Type.OTHER),
		    new Dish("pizza", true, 550, Dish.Type.OTHER),
		    new Dish("prawns", false, 300, Dish.Type.FISH),
		    new Dish("salmon", false, 450, Dish.Type.FISH) );
	
	public static void main(String[] args) {
		
		testPartitionPredicate();
		testReducing();
	}
	
	public static void testPartitionPredicate() {
		
		System.out.println("==========testPartitionPredicate=============");
		Map<Boolean, List<Dish>> map = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
		Optional.of(map).ifPresent(System.out::println);
		Map<Boolean, Double> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.averagingInt(Dish::getCalories)));
		Optional.of(collect).ifPresent(System.out::println);
	}
	public static void testReducing() {
		
		System.out.println("==========testReducing=============");
		Optional<Dish> collect = menu.stream().collect(Collectors.reducing(BinaryOperator
				.maxBy(Comparator.comparingInt(Dish::getCalories))));
		collect.ifPresent(System.out::println);
		
	}
}
