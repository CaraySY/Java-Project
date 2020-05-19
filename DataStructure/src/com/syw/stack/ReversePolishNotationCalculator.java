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
	 * 	�����׺���ʽ
	 * @param list
	 * @return
	 */
	public int calculate(List<String> list) {
		
		int res=0;
		String item="";
		for(int i=0;i<list.size();i++) {
			item=list.get(i);
			if(item.matches("\\d+")) { //�ж�����������ֵĻ�ֱ��ѹ��ջ��
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
					throw new RuntimeException("���������~");
				}
				stack.push(res+"");
			}
		}
		res=Integer.parseInt(stack.pop());
		return res;
	}
	
	
	public List<String> toInfixExpression(String expression){
		
		List<String> list=new ArrayList<>();
		int index=0; //����ɨ���ַ���
		char ch; //���浱ǰɨ����ַ�
		String keepNum=""; //���ڴ����λ��
		do {
			/*���� [0-9] ��ASCII�룺[48-57]*/
			if((ch=expression.charAt(index)) < 48 || (ch=expression.charAt(index)) > 57) {
				list.add(ch+"");
				index++;
			}else {
				
				keepNum="";//ÿ�ζ�Ҫ��ձ����λ���ķ���
				/*��Ҫ���ж��Ƿ񵽴��ַ���ĩβ*/
				while(index < expression.length() && (ch=expression.charAt(index)) >= 48 && (ch=expression.charAt(index)) <= 57) {
					keepNum=keepNum+ch;
					index++;
					/*��ȡ��һ���ַ�*/
				}
				list.add(keepNum);//����λ��ѹ��ջ��
			}
		}while(index < expression.length());
		
		return list;
	}
	
	public List<String> parseSuffixExpression(List<String> infixExpression){
		
		/*����s1[����ջ] s2ջ[�м���ջ]--->s2û�г�ջ������ʹ��ArrayList���*/
		Stack<String> s1=new Stack<>();
		List<String> s2=new ArrayList<>();
		for(String item : infixExpression) {
			//��������֣�ֱ��ѹ��ջs2��
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {//���������ţ�ѹ��s1��ջ��
				s1.push(item);
			}else if(item.equals(")")){//����������
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//���������Ƴ�����ʱһ�������Ѿ��Ƴ�
			}else { //���������
				/*��ǰ�����С�ڵ���ջ�����������Ҫ��s1ջ�������������ѹ��s2*/
				while(s1.size()!=0 && Operation.getPriority(item) <= Operation.getPriority(s1.peek())) {
					s2.add(s1.pop());
				}
				/*s1Ϊ�ջ������ȼ�����ջ����������ȼ���ֱ����ջ*/
				s1.push(item);
			}
		}
		/*��s1ʣ��ļ���s2*/
		while(s1.size()!=0) {
			s2.add(s1.pop());
		}
		return s2;
	}
	
	/**
	 * 	������������ȼ�����
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
					System.out.println("���������...");
					break;
			}
			return res;
		}
	}
	
}
