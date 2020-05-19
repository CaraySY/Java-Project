package com.syw.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotationCalculator {

	private Stack<String> stack=new Stack<>();
	
	public List<String> getCharacterList(String expression){
		
		String[] split = expression.split(" ");
		List<String> list=new ArrayList<>();
		for(String temp:split) {
			list.add(temp);
		}
		return list;
	}
	
	/**
	 * 	计算后缀表达式
	 * @param list
	 * @return
	 */
	public int calculate(List<String> list) {
		
		int res=0;
		String item="";
		for(int i=0;i<list.size();i++) {
			item=list.get(i);
			if(item.matches("\\d+")) { //判断如果这是数字的话直接压入栈中
				stack.push(item);
			}else {
				int num1=Integer.parseInt(stack.pop());
				int num2=Integer.parseInt(stack.pop());
				char oper=item.charAt(0);
				switch(oper) {
				case '+':
					res=num2+num1;
					break;
				case '-':
					res=num2-num1;
					break;
				case '*':
					res=num2*num1;
					break;
				case '/':
					res=num2/num1;
					break;
				default:
					throw new RuntimeException("运算符出错~");
				}
				stack.push(res+"");
			}
		}
		res=Integer.parseInt(stack.pop());
		return res;
	}
	
	
	public List<String> toInfixExpression(String expression){
		
		List<String> list=new ArrayList<>();
		int index=0; //用于扫描字符串
		char ch; //保存当前扫描的字符
		String keepNum=""; //用于处理多位数
		do {
			/*数字 [0-9] 的ASCII码：[48-57]*/
			if((ch=expression.charAt(index)) < 48 || (ch=expression.charAt(index)) > 57) {
				list.add(ch+"");
				index++;
			}else {
				
				keepNum="";//每次都要清空保存多位数的符号
				/*需要先判断是否到达字符串末尾*/
				while(index < expression.length() && (ch=expression.charAt(index)) >= 48 && (ch=expression.charAt(index)) <= 57) {
					keepNum=keepNum+ch;
					index++;
					/*获取下一个字符*/
				}
				list.add(keepNum);//将多位数压入栈中
			}
		}while(index < expression.length());
		
		return list;
	}
	
	public List<String> parseSuffixExpression(List<String> infixExpression){
		
		/*定义s1[符号栈] s2栈[中间结果栈]--->s2没有出栈操作，使用ArrayList替代*/
		Stack<String> s1=new Stack<>();
		List<String> s2=new ArrayList<>();
		for(String item : infixExpression) {
			//如果是数字，直接压入栈s2中
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {//遇到左括号，压入s1的栈中
				s1.push(item);
			}else if(item.equals(")")){//遇到右括号
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//将左括号移除，此时一对括号已经移除
			}else { //遇到运算符
				/*当前运算符小于等于栈顶运算符，需要将s1栈顶的运算符弹出压入s2*/
				while(s1.size()!=0 && Operation.getPriority(item) <= Operation.getPriority(s1.peek())) {
					s2.add(s1.pop());
				}
				/*s1为空或者优先级大于栈顶运算符优先级，直接入栈*/
				s1.push(item);
			}
		}
		/*将s1剩余的加入s2*/
		while(s1.size()!=0) {
			s2.add(s1.pop());
		}
		return s2;
	}
	
	/**
	 * 	返回运算符优先级的类
	 * @author Administrator
	 *
	 */
	private static class Operation{
		
		private static int ADD=1;
		private static int SUB=1;
		private static int MUL=2;
		private static int DIV=2;
		
		public static int getPriority(String oper) {
			
			int res=0;
			switch(oper){
				case "+":
					res=ADD;
					break;
				case "-":
					res=SUB;
					break;
				case "*":
					res=MUL;
					break;
				case "/":
					res=DIV;
					break;
				default:
					System.out.println("运算符出错...");
					break;
			}
			return res;
		}
	}
	
}
