package com.wsy.buffer;

import java.util.Arrays;

public class ChildClass extends SuperClass{

	private int x;
	private int y;
	
	public ChildClass() {
		//super();
		//this(5,3);
		System.out.println("construcotr:"+super.getClass().getName());
	}

	public ChildClass(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	protected int add(int a, int b) {
		
		System.out.println("this is child to execute add method.");
		return super.add(a, b);
	}

	public static void main(String[] args) {
		
		SuperClass sup=new ChildClass();
		System.out.println(sup.add(4, 6));
		int a=2;
		int b=3;
		int[] array= {1,3,5,6,2};
		change(array);
		System.out.println(Arrays.toString(array));
		new ChildClass().test();
	}
	
	public static void change(int[] array) {
		
		array[0]=10;
		System.out.println(Arrays.toString(array));
		
	}
	
	public void test() {
		// return class name of child
		System.out.println(super.getClass().getName());
		System.out.println(super.getClass().getSuperclass().getName());
		
	}
}
