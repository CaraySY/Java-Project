package com.syw.stack;

public class Calculator {

	/**
	 * @param expression 3+2*6-2  ��������ı��ʽ
	 * @return ���������Ľ��
	 */
	public int calculation(String expression) {
		
		/*�����������ջ*/
		ArrayStack numStack=new ArrayStack(10);
		/*�����������ջ*/
		ArrayStack operStack=new ArrayStack(10);
		int res=0;//������
		int num1=0;//������1 --> ��ѹ��ջ�ȵ��������� 
		int num2=0;//������2 --> ��ѹ��ջ�󵯳�������
		int oper=0;//�����
		int index=0;//�������������ʽ
		char ch=' ';//���ڻ�ȡÿһ���ַ�
		String keepNum="";//���ڴ����λ��
		/*��ʼѭ��ɨ�� expression*/
		while(true) {
			/*��ȡ���ʽ��һ���ַ�*/
			ch=expression.substring(index, index+1).charAt(0);
			/*�жϵ�ǰ�ַ��Ƿ��������*/
				/*����������*/
			if(operStack.isOper(ch)) {
				//���жϷ���ջ�Ƿ�Ϊ�գ��վ�ֱ��ѹ��ջ
				if(!operStack.isEmpty()) {
					/* �����ǰ�����С�ڻ��ߵ��������ջ�����ȼ� */
					/* ������ջ�е���������ջ�е�������������� */
					/* ����Ľ��ѹ����ջ�� */
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						/* ������ѧ���� */
						res = numStack.cal(num1, num2, oper);
						/* �������ջ */
						numStack.push(res);
						/* ��ǰ������������ջ */
						operStack.push(ch);
					} else {
						/* ֱ�ӽ������ѹ�������ջ�� */
						operStack.push(ch);
					}
				}else {
					/*��ջֱ��ѹ�������ջ*/
					operStack.push(ch);
				}
			}			/*���������*/
			else {
				/*�����λ�������ܷ�����һ������������ջ*/
				/*�������һλ*/
				keepNum+=ch;
				/*�����ǰλ�Ǳ��ʽ�����һλ��ֱ��ѹ��ջ��*/
				if(index==expression.length()-1) {
					numStack.push(Integer.parseInt(keepNum)); //���ַ���Ϊ��������
				}else {
					/*��ǰ����λ����һλ���������ֱ����ջ*/
					if(operStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
						
						numStack.push(Integer.parseInt(keepNum)); //���ַ���Ϊ��������
						keepNum="";//������ո��ַ�
					}
				}
			}
			index++;
			/*�ж��Ƿ�ɨ�赽�ַ���ĩβ����ѭ��*/
			if(index >= expression.length()) {
				break;
			}
		}
		/*ʹ��operStack���ж��Ƿ�������ϣ���operStackΪ�գ�numStack������Ȼ�����յĽ��*/
		while(true) {
			if(operStack.isEmpty()) {
				break;
			}
			num1=numStack.pop();
			num2=numStack.pop();
			oper=operStack.pop();
			res=numStack.cal(num1, num2, oper);
			/*���Ľ����ջ*/
			numStack.push(res);
		}
		return res;
	}
	
	private class ArrayStack {

		private int maxSize;
		private int top;
		private int[] stack;
		
		/*��ʼ��ջ*/
		public ArrayStack(int maxSize) {

			this.maxSize=maxSize;
			this.top=-1;
			this.stack=new int[maxSize];
		}
		
		/*ѹ��ջ*/
		public void push(int data) {
			
			/*���ջ���ˣ��޷���������*/
			if(isFull()) {
				System.out.println("ջ�����޷������µ�����...");
				return;
			}
			stack[++top]=data;
		}
		
		/*��ջ*/
		public int pop() {
			
			if(isEmpty()) {
				throw new RuntimeException("ջΪ�գ��޷�pop...");
			}
			return stack[top--];
		}
		
		/*��ȡջ�����ݣ�û�г�ջ*/
		public int peek() {
			
			return stack[top];
		}
		
		/*��������趨���ȼ�*/
		/**
		 * 	�ٶ������ֻ�� [��+��-��*��/]
		 * @param oper �����
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
		 * 	�ж��Ƿ��������
		 * @param oper �����
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
		 * 	���㷽��
		 * @param num1 ����1 --> ��ѹ��ջ�ȵ��������� 
		 * @param num2 ����2 --> ��ѹ��ջ�󵯳�������
		 * @param oper ������
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
