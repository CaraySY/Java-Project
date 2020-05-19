package com.wsy.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BracketsMatch {

	public static void main(String[] args) {
		boolean flag=bracketsMatch("]");
		System.out.println(flag);
	}
	
	/**
	 * 	�Լ�д��
	 * @param s
	 * @return
	 */
	public static boolean bracketsMatch(String s) {
		
		Stack<Character> left_stack=new Stack<>(); //����������
		List<Boolean> right_stack=new ArrayList<>(); // ��ջ����Ƿ�ƥ��
		char item=' ';
		for(int i=0;i<s.length();i++) {
			item=s.charAt(i);
			switch (item) {
			case '(':
			case '[':
			case '{':
				left_stack.push(item);
				break;
			case ')':
				if(!left_stack.isEmpty()&&left_stack.peek()=='(') {
					right_stack.add(true);
					left_stack.pop();
					break;
				}else {
					right_stack.add(false);
					break;
				}
			case ']':
				if(!left_stack.isEmpty()&&left_stack.peek()=='[') {
					right_stack.add(true);
					left_stack.pop();
					break;
				}else {
					right_stack.add(false);
					break;
				}
			case '}':
				if(!left_stack.isEmpty()&&left_stack.peek()=='{') {
					right_stack.add(true);
					left_stack.pop();
					break;
				}else {
					right_stack.add(false);
					break;
				}
			}
		}
		for(boolean temp : right_stack) {
			if(temp!=true) {
				return false;
			}
		}
		return left_stack.isEmpty();
	}
	
	//ʹ��hashMap key-value ƥ��
	private static Map<Character,Character> map=new HashMap<>();
	
	/**
	 * 	�ο��𰸼򵥡�����ʹ��Has��Map�ܹ������ж��Ƿ����ĳ���ַ�
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		
		map.put(')','(');
		map.put(']','[');
		map.put('}','{');
		Stack<Character> stack=new Stack<>(); //����������
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			//�ж��Ƿ��Ǳպ����� [������]
			if(map.containsKey(c)) {
				// ��ȡջ��ջ���������ж�ջ�Ƿ�Ϊ��
				char top=stack.isEmpty() ? '#' : stack.pop();
				if(top!=map.get(c)) {
					return false;
				}
			}else {
				stack.push(c);
			}
		}
		
		return stack.isEmpty();
	}
}
