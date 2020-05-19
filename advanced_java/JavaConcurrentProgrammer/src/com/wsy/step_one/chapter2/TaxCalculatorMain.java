package com.wsy.step_one.chapter2;

/**
 * 	ʹ�ò���ģʽ���Java��Thread��Runnable
 * @author Administrator
 *
 */
public class TaxCalculatorMain {

	public static void main(String[] args) {
		
		/*��ͳģʽ*/
		CalculatorStragedy stragedy=new SimpleCalculatorStragedy();
		TaxCalculator tax=new TaxCalculator(10000,1500);
		tax.setStragedy(stragedy);
		double res = tax.calTax();
		System.out.println("˰��1:"+res);
		/*ʹ��lambda���ʽ---�ı�˰�ʼ��㷽ʽ*/
		stragedy=(s,b)->{
			
			return s*0.15+b*0.2;
		};
		tax.setStragedy(stragedy);
		res=tax.calTax();
		System.out.println("˰��2��"+res);
	}
}
