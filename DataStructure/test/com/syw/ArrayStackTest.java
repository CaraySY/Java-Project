package com.syw;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.syw.stack.ArrayStack;
import com.syw.stack.Calculator;
import com.syw.stack.LinkedStack;
import com.syw.stack.ReversePolishNotationCalculator;

public class ArrayStackTest {

	private Scanner keyboard=new Scanner(System.in);
	
	@Test
	public void fun1() {
		
		ArrayStack stack=new ArrayStack(5);
		String key="";//菜单输入
		for(int i=0;i<3;i++) {
			stack.push(i*i);
		}
		boolean loop=true;//控制是否退出菜单
		while(loop) {
			System.out.println("***************Welcome Stack Test Programmer******************");
			System.out.println("\t\t\tshow:显示栈");
			System.out.println("\t\t\texit:退出程序");
			System.out.println("\t\t\tpush:添加数据到栈中(入栈)");
			System.out.println("\t\t\tpop:从栈取出数据(出栈)");
			System.out.println("\t\t\t请输入选择:");
			key=keyboard.next();
			switch(key) {
			case "show":
				stack.print();
				break;
			case "exit":
				loop=false;
				break;
			case "push":
				System.out.println("请输入一个数：");
				int data=keyboard.nextInt();
				stack.push(data);
				break;
			case "pop":
				int pop = stack.pop();
				System.out.println("出栈的数据："+pop);
				break;
			default: 
				break;
			}
		}
	}
	
	@Test
	public void fun2() {
		
		LinkedStack stack=new LinkedStack();
		String key="";//菜单输入
		for(int i=0;i<3;i++) {
			stack.push(i*i);
		}
		boolean loop=true;//控制是否退出菜单
		while(loop) {
			System.out.println("***************Welcome Stack Test Programmer******************");
			System.out.println("\t\t\tshow:显示栈");
			System.out.println("\t\t\texit:退出程序");
			System.out.println("\t\t\tpush:添加数据到栈中(入栈)");
			System.out.println("\t\t\tpop:从栈取出数据(出栈)");
			System.out.println("\t\t\t请输入选择:");
			key=keyboard.next();
			switch(key) {
			case "show":
				stack.print();
				break;
			case "exit":
				loop=false;
				break;
			case "push":
				System.out.println("请输入一个数：");
				int data=keyboard.nextInt();
				stack.push(data);
				break;
			case "pop":
				int pop = stack.pop();
				System.out.println("出栈的数据："+pop);
				break;
			default: 
				break;
			}
		}
	}
	
	/*中缀表达式计算器*/
	@Test
	public void fun3() {
		
		Calculator calculator=new Calculator();
		String expression="30+2*60-2";
		int res = calculator.calculation(expression);
		System.out.printf("expression:(%s)的结果是:[%d]\n",expression,res);
	}
	
	/*逆波兰表达式计算器*/
	@Test
	public void fun4() {
		
		ReversePolishNotationCalculator calculator=new ReversePolishNotationCalculator();
		//原始表达式String expression="(3+4)*5-6";
		String expression="30 4 + 5 * 6 -";
		
		List<String> characterList = calculator.getCharacterList(expression);
		int res=calculator.calculate(characterList);
		System.out.println("运算结果是："+res);
	}
	
	/*
	 * 将中缀表达式  1+((2+3))*4)-5 --> 1 2 3 + 4 * + 5 - 
	 */
	@Test
	public void fun5() {
		
		ReversePolishNotationCalculator calculator=new ReversePolishNotationCalculator();
		String expression="1-((2+3)*4)-5";
		List<String> infixExpressionList = calculator.toInfixExpression(expression);
		List<String> suffixExpressionList = calculator.parseSuffixExpression(infixExpressionList);
		System.out.println("中缀表达式="+infixExpressionList.toString());
		System.out.println("后缀表达式="+suffixExpressionList.toString());
	}
}
