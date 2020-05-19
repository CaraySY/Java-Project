package com.wsy.step_one.chapter2;

/**
 * 	实现该策略的计算税率的方法
 * @author Administrator
 *
 */
public class SimpleCalculatorStragedy implements CalculatorStragedy{

	@Override
	public double calculate(double salary, double bonus) {

		return salary*0.1+bonus*0.15;
	}

}
