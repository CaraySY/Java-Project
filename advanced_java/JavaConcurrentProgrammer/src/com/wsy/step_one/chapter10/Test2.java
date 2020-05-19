package com.wsy.step_one.chapter10;

import java.util.Arrays;
import java.util.Optional;

/**
 * 	��ȡ����ջ����Ϣ
 * @author Administrator
 *
 */
public class Test2 {

	public void test() {
		
		Arrays.asList(Thread.currentThread().getStackTrace()).stream()
			//����
			.filter(e->!e.isNativeMethod())
			.forEach(e->Optional.of(e.getClassName()+":"+
							e.getMethodName()+":"+e.getLineNumber())
							.ifPresent(System.out::println));
	}
}
