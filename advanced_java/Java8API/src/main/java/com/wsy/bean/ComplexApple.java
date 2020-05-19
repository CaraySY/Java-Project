package com.wsy.bean;

public class ComplexApple {

	private String color;
	private String name;
	private long weight;
	
	
	public ComplexApple(String color, String name,long weight) {
		super();
		this.color = color;
		this.name=name;
		this.weight = weight;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ComplexApple [color=" + color + ", name=" + name + ", weight=" + weight + "]";
	}
}
