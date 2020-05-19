package com.syw.bean;

import java.io.Serializable;

/**
 * 	Java序列化
 * @author Administrator
 *
 */
public class Person implements Serializable{

	/**
	 * 	序列化ID
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer age;
	
	public Person() {
		
		System.out.println("序列化调用构造方法...");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
