package com.wsy.optional;

import java.util.Optional;

import com.wsy.bean.Car;
import com.wsy.bean.Insurance;
import com.wsy.bean.Person;

public class OptionalInAction {

	public static void main(String[] args) {
		
		String res=getInsuranceName(new Person());
		Optional.ofNullable("res="+res).ifPresent(System.out::println);
	}
	
	public static String getInsuranceName(Person person) {
		
		return Optional.ofNullable(person).flatMap(Person::getCar)
			.flatMap(Car::getInsurance).map(Insurance::getName).orElse("empty value");
	}
}
