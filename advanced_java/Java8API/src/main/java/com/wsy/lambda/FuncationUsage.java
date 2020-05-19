package com.wsy.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

import com.wsy.bean.Apple;

public class FuncationUsage {

	public static String testFunction(Apple apple,Function<Apple,String> func) {
		
		return func.apply(apple);
	}
	
	public static Apple testBiFunction(BiFunction<String,Long,Apple> func,String color,Long weight) {
		
		return func.apply(color, weight);
	}
	
	public static Double testIntFunc(IntFunction<Double> func,Integer para) {
		
		return func.apply(para);
	}
	
	public static Apple createSupplier(Supplier<Apple> supplier) {
		
		return supplier.get();
	}
	
	public static void main(String[] args) {
		
		List<Apple> list=Arrays.asList(new Apple("green",120),
				new Apple("green",150),new Apple("red",140));
		String color=testFunction(list.get(new Random().nextInt(3)), (apple)->apple.toString());
		System.out.println("color:"+color);
		System.out.println("=======================");
		Double res = testIntFunc((para)->para*5.0,10);
		System.out.println(res.doubleValue());
		System.out.println("=======================");
		Apple apple=testBiFunction((c,weight)-> new Apple(c,weight), "green", 150L);
		System.out.println(apple);
		Supplier<String> s=String::new; // method inference
		Supplier<String> s2=()->new String("I love you");
		System.out.println(s2.get());
		System.out.println(s.get().getClass());
		System.out.println("=======================");
		System.out.println(createSupplier(()->new Apple("blue",150)));
		System.out.println("=======================");
		final int i=0;
		Runnable r=()->{
			System.out.println(i); // must be final type
		};
		new Thread(r,"t1").start();
	}
}
