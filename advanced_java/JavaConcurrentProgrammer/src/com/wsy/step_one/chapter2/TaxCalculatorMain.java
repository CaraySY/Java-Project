package com.wsy.step_one.chapter2;

/**
 * 	使用策略模式理解Java的Thread、Runnable
 * @author Administrator
 *
 */
public class TaxCalculatorMain {

	public static void main(String[] args) {
		
		/*传统模式*/
		CalculatorStragedy stragedy=new SimpleCalculatorStragedy();
		TaxCalculator tax=new TaxCalculator(10000,1500);
		tax.setStragedy(stragedy);
		double res = tax.calTax();
		System.out.println("税率1:"+res);
		/*使用lambda表达式---改变税率计算方式*/
		stragedy=(s,b)->{
			
			return s*0.15+b*0.2;
		};
		tax.setStragedy(stragedy);
		res=tax.calTax();
		System.out.println("税率2："+res);
	}
}
