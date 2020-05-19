package com.wsy.func_interface;

@FunctionalInterface
public interface ThreeAppleFunction<T,U,Z,R> {

	R apply(T t,U u,Z z);
}
