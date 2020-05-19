package com.wsy.optional;

import java.util.Optional;

import com.wsy.bean.Insurance;

/**
 * 	How to create Optional instance:
 * 	of empty ofNullable
 * @author Administrator
 *
 */
public class OptioanlUsage {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Optional<Insurance> empty = Optional.<Insurance>empty();
		//System.out.println(empty.get());
		Optional<Insurance> of = Optional.of(new Insurance());
		System.out.println(of.get());
		Optional<Insurance> ofNullable = Optional.ofNullable(new Insurance());
		System.out.println(ofNullable.get());
		Insurance orElse = ofNullable.orElse(new Insurance());
		System.out.println(orElse);
		Insurance orElseGet = ofNullable.orElseGet(Insurance::new);
		System.out.println(orElseGet);
		Insurance orElseThrow = ofNullable.orElseThrow(()->new RuntimeException("not find exception..."));
		System.out.println(orElseThrow);
		System.out.println("==============================");
		Insurance of2 = of.filter(insurance->insurance.getName()!=null).get();
		System.out.println(of2);
		Optional<String> map = of.map(insurance->insurance.getName());
		System.out.println(map.orElse("Empty Value"));
		map.ifPresent(System.out::println);
		String name = getInsurance(new Insurance());
		System.out.println(name);
	}
	
	public static String getInsurance(Insurance insurance) {
		
		return Optional.ofNullable(insurance).map(Insurance::getName).orElse("empty value");
	}
}
