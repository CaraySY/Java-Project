package com.syw.stack;

public class Calculator {

	/**
	 * @param expression 3+2*6-2  参与运算的表达式
	 * @return 返回运算后的结果
	 */
	public int calculation(String expression) {
		
		/*保存操作数的栈*/
		ArrayStack numStack=new ArrayStack(10);
		/*保存运算符的栈*/
		ArrayStack operStack=new ArrayStack(10);
		int res=0;//保存结果
		int num1=0;//操作数1 --> 后压入栈先弹出来的数 
		int num2=0;//操作数2 --> 先压入栈后弹出来的数
		int oper=0;//运算符
		int index=0;//索引，遍历表达式
		char ch=' ';//用于获取每一个字符
		String keepNum="";//用于处理多位数
		/*开始循环扫描 expression*/
		while(true) {
			/*获取表达式的一个字符*/
			ch=expression.substring(index, index+1).charAt(0);
			/*判断当前字符是否是运算符*/
				/*如果是运算符*/
			if(operStack.isOper(ch)) {
				//先判断符号栈是否为空，空就直接压入栈
				if(!operStack.isEmpty()) {
					/* 如果当前运算符小于或者等于运算符栈的优先级 */
					/* 弹出数栈中的两个符和栈中的运算符进行运算 */
					/* 运算的结果压入数栈中 */
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						/* 进行数学运算 */
						res = numStack.cal(num1, num2, oper);
						/* 结果入数栈 */
						numStack.push(res);
						/* 当前运算符入运算符栈 */
						operStack.push(ch);
					} else {
						/* 直接将运算符压入运算符栈中 */
						operStack.push(ch);
					}
				}else {
					/*空栈直接压入运算符栈*/
					operStack.push(ch);
				}
			}			/*不是运算符*/
			else {
				/*处理多位数，不能发现是一个数就立即入栈*/
				/*必须向后看一位*/
				keepNum+=ch;
				/*如果当前位是表达式的最后一位，直接压入栈中*/
				if(index==expression.length()-1) {
					numStack.push(Integer.parseInt(keepNum)); //将字符变为整型数据
				}else {
					/*当前数字位的下一位是运算符就直接入栈*/
					if(operStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
						
						numStack.push(Integer.parseInt(keepNum)); //将字符变为整型数据
						keepNum="";//必须清空该字符
					}
				}
			}
			index++;
			/*判断是否扫描到字符串末尾跳出循环*/
			if(index >= expression.length()) {
				break;
			}
		}
		/*使用operStack来判断是否运算完毕，当operStack为空，numStack的数必然是最终的结果*/
		while(true) {
			if(operStack.isEmpty()) {
				break;
			}
			num1=numStack.pop();
			num2=numStack.pop();
			oper=operStack.pop();
			res=numStack.cal(num1, num2, oper);
			/*最后的结果入栈*/
			numStack.push(res);
		}
		return res;
	}
	
	private class ArrayStack {

		private int maxSize;
		private int top;
		private int[] stack;
		
		/*初始化栈*/
		public ArrayStack(int maxSize) {

			this.maxSize=maxSize;
			this.top=-1;
			this.stack=new int[maxSize];
		}
		
		/*压入栈*/
		public void push(int data) {
			
			/*如果栈满了，无法插入数据*/
			if(isFull()) {
				System.out.println("栈满，无法插入新的数据...");
				return;
			}
			stack[++top]=data;
		}
		
		/*出栈*/
		public int pop() {
			
			if(isEmpty()) {
				throw new RuntimeException("栈为空，无法pop...");
			}
			return stack[top--];
		}
		
		/*获取栈顶数据，没有出栈*/
		public int peek() {
			
			return stack[top];
		}
		
		/*给运算符设定优先级*/
		/**
		 * 	假定运算符只有 [加+减-乘*除/]
		 * @param oper 运算符
		 * @return
		 */
		public int priority(int oper) {
			
			if(oper == '*' || oper == '/') {
				return 1;
			}else if(oper == '+' || oper == '-') {
				return 0;
			}else {
				return -1;
			}
		}
		
		/**
		 * 	判断是否是运算符
		 * @param oper 运算符
		 * @return
		 */
		public boolean isOper(int oper) {
			
			if(oper == '*' || oper == '/' || oper == '+' || oper == '-') {
				return true;
			}else {
				return false;
			}
		}
		
		/**
		 * 	计算方法
		 * @param num1 数字1 --> 后压入栈先弹出来的数 
		 * @param num2 数字2 --> 先压入栈后弹出来的数
		 * @param oper 操作符
		 */
		public int cal(int num1,int num2,int oper) {
			
			int res=0;
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
				break;
			}
			return res;
		}
		
		
		public boolean isEmpty() {
			
			return top==-1;
		}
		
		public boolean isFull() {
			
			return top==maxSize-1;
		}
	}
}
