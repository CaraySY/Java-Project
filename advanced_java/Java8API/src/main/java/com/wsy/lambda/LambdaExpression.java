package com.wsy.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.wsy.bean.Apple;

@SuppressWarnings("unused")
public class LambdaExpression {

	public static void main(String[] args) {
		
		Function<String,Integer> strFunction= s -> s.length();
		
		Predicate<Apple> predicte=apple -> apple.getColor().equals("green");
		
		Supplier<Apple> s=Apple::new;
		
		Consumer<Apple> c=Apple::getColor;
		
	}
}
