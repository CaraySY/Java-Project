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
	 * 	自己写的
	 * @param s
	 * @return
	 */
	public static boolean bracketsMatch(String s) {
		
		Stack<Character> left_stack=new Stack<>(); //保存左括号
		List<Boolean> right_stack=new ArrayList<>(); // 右栈存放是否匹配
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
	
	//使用hashMap key-value 匹配
	private static Map<Character,Character> map=new HashMap<>();
	
	/**
	 * 	参考答案简单。。。使用Has和Map能够快速判断是否包含某个字符
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		
		map.put(')','(');
		map.put(']','[');
		map.put('}','{');
		Stack<Character> stack=new Stack<>(); //保存左括号
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			//判断是否是闭合括号 [右括号]
			if(map.containsKey(c)) {
				// 获取栈的栈顶，首先判断栈是否为空
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
