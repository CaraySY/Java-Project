package com.wsy.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.wsy.bean.Apple;
import com.wsy.bean.ComplexApple;
import com.wsy.func_interface.ThreeAppleFunction;

/**
 * @author Administrator
 *
 */
public class AdvancedMethodInference {

	public static void main(String[] args) {
		
		// use static method to infer
		Function<String,Integer> f1=Integer::parseInt;
		System.out.println(f1.apply("123"));
		// use class to infer
		BiFunction<String,Integer,Character> f2=String::charAt;
		Character c = f2.apply("HELLO", 2);
		System.out.println(c);
		// use class' instance to infer
		String s=new String("WORLD");
		Function<Integer,Character> f3=s::charAt;
		System.out.println(f3.apply(2));
		// 
		BiFunction<String,Integer,Apple> func=Apple::new;
		System.out.println(func.apply("skyblue", 122));
		System.out.println("=======Custom Interface======");
		ThreeAppleFunction<String, String, Integer, ComplexApple> tfunc=ComplexApple::new;
		ComplexApple cA=tfunc.apply("green", "xiaoAI", 150);
		System.out.println(cA);
		System.out.println("=============================");
		List<Apple> list=Arrays.asList(new Apple("green",120),
				new Apple("yellow",150),new Apple("red",140));
		System.out.println("before...");
		list.stream().forEach(System.out::println); // method inference
		list.sort(Comparator.comparing(Apple::getColor));
		
	}
}
