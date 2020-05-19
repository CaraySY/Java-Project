package com.wsy.step_one.chapter10;

/**
 * 	捕获程序递归调用栈的信息
 * @author Administrator
 *
 */
public class CaptureRuntimeStackTrace {

	public static void main(String[] args) {
		
		Test1 test=new Test1();
		test.test();
	}
}
