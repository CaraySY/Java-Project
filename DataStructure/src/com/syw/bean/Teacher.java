package com.syw.bean;

import java.io.Serializable;

public class Teacher extends Person implements Serializable{

	/**
	 *  序列化ID
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Person person;
	
	public Teacher() {
		
		System.out.println("调用构造方法...(Teacher)");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", person=" + person + "]";
	}
}
