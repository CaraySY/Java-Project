package com.wsy.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wsy.bean.Apple;

public class AppleFilterTest {

	@FunctionalInterface
	public interface AppleFilter{
		
		boolean filter(Apple apple);
	}
	
	public static List<Apple> findGreenApple(List<Apple> apples){
		
		List<Apple> list=new ArrayList<>();
		for(Apple apple : apples) {
			if("green".equals(apple.getColor())) {
				list.add(apple);
			}
		}
		return list;
	}
	
	public static List<Apple> findGreenApple(List<Apple> apples,AppleFilter appleFilter){
		
		List<Apple> list=new ArrayList<>();
		for(Apple apple : apples) {
			if(appleFilter.filter(apple)) {
				list.add(apple);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		
		List<Apple> list=Arrays.asList(new Apple("green",120),new Apple("green",150),new Apple("red",140));
		/*
		 * List<Apple> res=findGreenApple(list); for(Apple apple:res) {
		 * System.out.println(apple); }
		 */
		List<Apple> greenApple = findGreenApple(list,(Apple apple)->{
			return apple.getColor().equals("green");
		});
		greenApple.stream().forEach(System.out::println);
	}
}
