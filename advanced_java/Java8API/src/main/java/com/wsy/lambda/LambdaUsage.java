package com.wsy.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import com.wsy.bean.Apple;

/**
 * 	// only have a method
	@FunctionalInterface
	public interface Adder{
		
		int add(int a,int b);
	}
 * @author Administrator
 *
 */
public class LambdaUsage {

	public static List<Apple> filter(List<Apple> source,Predicate<Apple> predicate){
		
		List<Apple> res=new ArrayList<>();
		for(Apple apple : source) {
			if(predicate.test(apple)) {
				res.add(apple);
			}
		}
		
		return res;
	}
	
	public static List<Apple> getWeightFilter(List<Apple> source,LongPredicate predicate){
		
		List<Apple> res=new ArrayList<>();
		for(Apple apple : source) {
			if(predicate.test(apple.getWeight())) {
				res.add(apple);
			}
		}
		
		return res;
	}
	
	public static void simpleConsumer(List<Apple> source,Consumer<Apple> consumer){
		
		for(Apple apple:source) {
			consumer.accept(apple);
		}
	}
	public static void biConsumer(List<Apple> source,BiConsumer<Apple,String> consumer,String p){
		
		for(Apple apple:source) {
			consumer.accept(apple,p);
		}
	}
	
	public static void main(String[] args) {
		
		Runnable r1=()-> System.out.println("Hello world 1");
		Runnable r2=new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Hello world 2");
			}
		};
		process(r1);
		process(r2);
		process(()->System.out.println("Hello world 3"));
		System.out.println("===============================");
		List<Apple> list=Arrays.asList(new Apple("green",120),
				new Apple("green",150),new Apple("red",140));
		List<Apple> res = filter(list, (apple)->apple.getColor().equals("green"));
		res.stream().forEach(System.out::println);
		System.out.println("===============================");
		List<Apple> res2 = getWeightFilter(list,(weight)->weight > 130);
		res2.stream().forEach(System.out::println);
		System.out.println("******simple consumer******");
		simpleConsumer(list, (apple)->System.out.println(apple));
		System.out.println("===============================");
		biConsumer(list, (apple,para)->{
			System.out.println(para+apple.getWeight());
		}, "XXX]");
	}
	
	public static void process(Runnable r) {
		
		try {
			new Thread(r).start();
			Thread.sleep(1_00);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
