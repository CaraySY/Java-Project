package com.wsy.step_one.chapter2;

public class TaxCalculator {

	private final double salary;
	private final double bonus;
	//����һ�����Լ���˰��
	private CalculatorStragedy stragedy;
	
	public TaxCalculator(double salary, double bonus) {
		super();
		this.salary = salary;
		this.bonus = bonus;
	}

	public double calTax() {
		
		return stragedy.calculate(salary, bonus);
	}

	public void setStragedy(CalculatorStragedy stragedy) {
		this.stragedy = stragedy;
	}
}
