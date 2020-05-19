package com.wsy.collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.wsy.bean.Apple;

public class CollectorIntroduce {

	public static void main(String[] args) {
		
		List<Apple> fruits=Arrays.asList(
				new Apple("green",120),
				new Apple("green",150),
				new Apple("red",140),
				new Apple("yellow",130),
				new Apple("blue",140),
				new Apple("purple",130)
			);
		List<Apple> res=fruits.stream().filter(apple->apple.getColor().equals("green"))
				.collect(Collectors.toList());
		Optional.ofNullable(res).ifPresent(System.out::println);
		// group by color
		Map<String, List<Apple>> map = groupByColor(fruits);
		System.out.println(map);
		System.out.println("++++++++++++++++++++++++++++++++");
		Optional.ofNullable(groupByColorFunc(fruits)).ifPresent(System.out::println);
		System.out.println("++++++++++++++++++++++++++++++++");
		Optional.ofNullable(groupByColorCollector(fruits)).ifPresent(System.out::println);
		
	}
	
	public static Map<String,List<Apple>> groupByColor(List<Apple> source){
		
		Map<String,List<Apple>> map=new HashMap<>();
		for(Apple apple:source) {
			List<Apple> list = map.get(apple.getColor());
			if(list==null) {
				list=new ArrayList<>();
				map.put(apple.getColor(),list);
			}
			list.add(apple);
		}
		return map;
	}
	
	public static Map<String,List<Apple>> groupByColorFunc(List<Apple> source){
		
		Map<String,List<Apple>> map=new HashMap<>();
		source.stream().forEach(apple->{
			List<Apple> elseGet = Optional.ofNullable(map.get(apple.getColor())).orElseGet(()->{
				List<Apple> list=new ArrayList<>();
				map.put(apple.getColor(), list);
				return list;
			});
			elseGet.add(apple);
		});
		return map;
	}
	
	public static Map<String,List<Apple>> groupByColorCollector(List<Apple> source){
		
		return source.stream().filter(apple->!apple.getColor().equals("green")).collect(Collectors.groupingBy(Apple::getColor));
	}
}
