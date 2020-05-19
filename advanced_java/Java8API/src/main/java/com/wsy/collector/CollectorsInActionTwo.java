package com.wsy.collector;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.wsy.bean.Dish;

public class CollectorsInActionTwo {

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
		
		testGroupingByConcurrent(MENU);
		testJoining(MENU);
		testJoiningWithSeparator(MENU);
		testJoiningWithSeparatorAndPrefixAndSuffix(MENU);
		testMapping(MENU);
		testMaxOrMin(MENU);
	}
	
	public static void testGroupingByConcurrent(List<Dish> menu) {
		
		System.out.println("==========testGroupingByConcurrent================");
		ConcurrentMap<Integer, List<Dish>> map = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getCalories));
		Optional.ofNullable(map.getClass()).ifPresent(System.out::println);
		Optional.ofNullable(map).ifPresent(System.out::println);
	}
	
	public static void testJoining(List<Dish> menu) {
		
		System.out.println("==========testJoining================");
		String join = menu.stream().map(Dish::getName).collect(Collectors.joining());
		Optional.ofNullable(join).ifPresent(System.out::println);
	}
	
	public static void testJoiningWithSeparator(List<Dish> menu) {
		
		System.out.println("==========testJoiningSeparator================");
		String join = menu.stream().map(Dish::getName).collect(Collectors.joining("-"));
		Optional.ofNullable(join).ifPresent(System.out::println);
	}
	
	public static void testJoiningWithSeparatorAndPrefixAndSuffix(List<Dish> menu) {
		
		System.out.println("==========testJoiningWithSeparatorAndPrefixAndSuffix================");
		String join = menu.stream().map(Dish::getName).collect(Collectors.joining("-","Names [","]"));
		Optional.ofNullable(join).ifPresent(System.out::println);
	}
	
	public static void testMapping(List<Dish> menu) {
		
		System.out.println("==========testMapping================");
		String join = menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(",")));
		Optional.ofNullable(join).ifPresent(System.out::println);
	}
	
	public static void testMaxOrMin(List<Dish> menu) {
		
		System.out.println("==========testMaxOrMin================");
		Optional<Dish> max = menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)));
		max.ifPresent(System.out::println);
		Optional<Dish> min = menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)));
		min.ifPresent(System.out::println);
	}
}
