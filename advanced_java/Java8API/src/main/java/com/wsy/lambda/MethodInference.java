package com.wsy.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.wsy.bean.Apple;

public class MethodInference {

	public static void main(String[] args) {
		
		useConsumer((s)->System.out.println(s),"Hello Alex");
		useConsumer(System.out::println,"Hello SYW");
		System.out.println("=========================");
		List<Apple> list=Arrays.asList(new Apple("green",120),
				new Apple("yellow",150),new Apple("red",140));
		System.out.println("before...");
		list.stream().forEach(System.out::println); // method inference
		list.sort((a,b)->a.getColor().compareTo(b.getColor()));
		System.out.println("after...");
		list.stream().forEach(System.out::println);
	}
	
	public static <T> void useConsumer(Consumer<T> consumer,T t) {
		
		consumer.accept(t);
	}
}
