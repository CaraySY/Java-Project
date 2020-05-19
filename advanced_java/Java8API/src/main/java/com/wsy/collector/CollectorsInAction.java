package com.wsy.collector;

import java.util.Arrays;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.wsy.bean.Dish;
import com.wsy.bean.Dish.Type;

public class CollectorsInAction {

	private static final List<Dish> MENU = Arrays.asList(
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
		
		testAveraging(MENU);
		testCollectingAndThen(MENU);
		testCounting(MENU);
		testGroupingBy(MENU);
		testGroupingBySupplierAndCollect(MENU);
		testSummerialOfCollectors(MENU);
	}
	
	public static void testAveraging(List<Dish> menu) {
		
		// Use Collectors 
		System.out.println("========double======");
		Optional.ofNullable(menu.stream()
				.collect(Collectors.averagingDouble(Dish::getCalories)))
				.ifPresent(System.out::println);
		// Use Collectors 
		System.out.println("========long======");
		Optional.ofNullable(menu.stream()
				.collect(Collectors.averagingLong(Dish::getCalories)))
		.ifPresent(System.out::println);
		// Use Collectors 
		System.out.println("========int======");
		Optional.ofNullable(menu.stream()
				.collect(Collectors.averagingInt(Dish::getCalories)))
		.ifPresent(System.out::println);
	}
	
	public static void testCollectingAndThen(List<Dish> menu) {
		
		System.out.println("============testAveraging=============");
		// return string 
		Optional.ofNullable(menu.stream().collect(Collectors
				.collectingAndThen(Collectors.averagingInt(
							Dish::getCalories), 
							res->"The average of Calories->"+res)))
				.ifPresent(System.out::println);
		// return a unmodified list
		List<Dish> collect = menu.stream().filter(dish->dish.getType().equals(Dish.Type.MEAT))
					.collect(Collectors.collectingAndThen(
							Collectors.toList(), 
							Collections::unmodifiableList));
		Optional.ofNullable(collect).ifPresent(System.out::println);
		
	}
	
	public static void testCounting(List<Dish> menu) {
		
		System.out.println("get count from menu...");
		Optional.ofNullable(menu.stream()
				.collect(Collectors.collectingAndThen(
						Collectors.counting(), 
						res->"the counting is->"+res)))
				.ifPresent(System.out::println);
	}
	
	public static void testGroupingBy(List<Dish> menu) {
		
		System.out.println("==========testGroupingBy================");
		Optional.of(menu.stream()
				.collect(Collectors
						.groupingBy(Dish::getType,Collectors.counting())))
				.ifPresent(System.out::println);
		Optional.of(menu.stream()
				.collect(Collectors
						.groupingBy(Dish::getType,Collectors.averagingDouble(Dish::getCalories))))
		.ifPresent(System.out::println);
	}
	
	public static void testGroupingBySupplierAndCollect(List<Dish> menu) {
		
		System.out.println("==========testGroupingBySupplierAndCollect================");
		Map<Type, Double> map = menu.stream()
				.collect(Collectors
						.groupingBy(Dish::getType,Collectors.averagingDouble(Dish::getCalories)));
		System.out.println(map.getClass());
		System.out.println(map);
		// return a specified type of map 
		Map<Type, Double> treeMap = menu.stream()
				.collect(Collectors
						.groupingBy(Dish::getType,TreeMap::new,Collectors.averagingDouble(Dish::getCalories)));
		System.out.println(treeMap.getClass());
		System.out.println(treeMap);
	}
	
	public static void testSummerialOfCollectors(List<Dish>  menu) {
		
		System.out.println("===========testSummerialOfCollectors================");
		DoubleSummaryStatistics statistics = menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
		Optional.ofNullable(statistics).ifPresent(System.out::println);
	}
}
