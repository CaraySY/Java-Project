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
		String key="";//�˵�����
		for(int i=0;i<3;i++) {
			stack.push(i*i);
		}
		boolean loop=true;//�����Ƿ��˳��˵�
		while(loop) {
			System.out.println("***************Welcome Stack Test Programmer******************");
			System.out.println("\t\t\tshow:��ʾջ");
			System.out.println("\t\t\texit:�˳�����");
			System.out.println("\t\t\tpush:������ݵ�ջ��(��ջ)");
			System.out.println("\t\t\tpop:��ջȡ������(��ջ)");
			System.out.println("\t\t\t������ѡ��:");
			key=keyboard.next();
			switch(key) {
			case "show":
				stack.print();
				break;
			case "exit":
				loop=false;
				break;
			case "push":
				System.out.println("������һ������");
				int data=keyboard.nextInt();
				stack.push(data);
				break;
			case "pop":
				int pop = stack.pop();
				System.out.println("��ջ�����ݣ�"+pop);
				break;
			default: 
				break;
			}
		}
	}
	
	@Test
	public void fun2() {
		
		LinkedStack stack=new LinkedStack();
		String key="";//�˵�����
		for(int i=0;i<3;i++) {
			stack.push(i*i);
		}
		boolean loop=true;//�����Ƿ��˳��˵�
		while(loop) {
			System.out.println("***************Welcome Stack Test Programmer******************");
			System.out.println("\t\t\tshow:��ʾջ");
			System.out.println("\t\t\texit:�˳�����");
			System.out.println("\t\t\tpush:������ݵ�ջ��(��ջ)");
			System.out.println("\t\t\tpop:��ջȡ������(��ջ)");
			System.out.println("\t\t\t������ѡ��:");
			key=keyboard.next();
			switch(key) {
			case "show":
				stack.print();
				break;
			case "exit":
				loop=false;
				break;
			case "push":
				System.out.println("������һ������");
				int data=keyboard.nextInt();
				stack.push(data);
				break;
			case "pop":
				int pop = stack.pop();
				System.out.println("��ջ�����ݣ�"+pop);
				break;
			default: 
				break;
			}
		}
	}
	
	/*��׺���ʽ������*/
	@Test
	public void fun3() {
		
		Calculator calculator=new Calculator();
		String expression="30+2*60-2";
		int res = calculator.calculation(expression);
		System.out.printf("expression:(%s)�Ľ����:[%d]\n",expression,res);
	}
	
	/*�沨�����ʽ������*/
	@Test
	public void fun4() {
		
		ReversePolishNotationCalculator calculator=new ReversePolishNotationCalculator();
		//ԭʼ���ʽString expression="(3+4)*5-6";
		String expression="30 4 + 5 * 6 -";
		
		List<String> characterList = calculator.getCharacterList(expression);
		int res=calculator.calculate(characterList);
		System.out.println("�������ǣ�"+res);
	}
	
	/*
	 * ����׺���ʽ  1+((2+3))*4)-5 --> 1 2 3 + 4 * + 5 - 
	 */
	@Test
	public void fun5() {
		
		ReversePolishNotationCalculator calculator=new ReversePolishNotationCalculator();
		String expression="1-((2+3)*4)-5";
		List<String> infixExpressionList = calculator.toInfixExpression(expression);
		List<String> suffixExpressionList = calculator.parseSuffixExpression(infixExpressionList);
		System.out.println("��׺���ʽ="+infixExpressionList.toString());
		System.out.println("��׺���ʽ="+suffixExpressionList.toString());
	}
}
