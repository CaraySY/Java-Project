package com.wsy.number;

public class PalindromeNumber {

	public static void main(String[] args) {
		
		boolean flag=isPalindromeNumber2(12321);
		System.out.println(flag);
	}
	
	/**
	 * 	����ƥ��
	 * @param x
	 * @return
	 */
	public static boolean isPalindromeNumber(int x) {
		
		if(x<0) {
			return false;
		}
		int[] stack=new int[(x+"").length()];
		int index=0;
		while(x!=0) {
			int pop=x%10; //��������ȡ��ÿһλ
			stack[index++]=pop;
			x=x/10;
		}
		for(int i=0,j=stack.length-1;i<stack.length && j>=0;i++,j--) {
			if(stack[i]==stack[j]) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 	�ж�һ��������һ��Ϳ��ԣ�˳�������������
	 *  0������Ļ�����
	 *   ���ǽ�ԭʼ���ֳ��� 10��Ȼ�����ת������ֳ��� 10��
	 *   ���ԣ���ԭʼ����С�ڷ�ת�������ʱ������ζ�������Ѿ�������һ��λ��������
	 * @param x
	 * @return
	 */
	public static boolean isPalindromeNumber2(int x) {
		
		/**
		 * 	������һλΪ 0 ����һλ�ض�Ϊ0����ʹ������-->x=0
		 */
		if(x < 0 || (x%10==0 && x!=0)) {
			return false;
		}
		/**
		 * �������� 1221�����ִ�� 1221 % 10�����ǽ��õ����һλ���� 1��
		 * Ҫ�õ������ڶ�λ���֣����ǿ�����ͨ������ 10 �����һλ���ִ� 1221 ���Ƴ���1221 / 10 = 122��
		 * �������һ��������� 10 ��������122 % 10 = 2���Ϳ��Եõ������ڶ�λ���֡�������ǰ����һλ���ֳ��� 10��
		 * �ټ��ϵ����ڶ�λ���֣�1 * 10 + 2 = 12��
		 * �͵õ���������Ҫ�ķ�ת������֡��������������̣����ǽ��õ�����λ���ķ�ת����
		 */
		int revertedNumber=0;
		while(x > revertedNumber) { // ��֤ǰ�벿���ִ��ڵ��ں�벿
			revertedNumber=revertedNumber*10+x%10;
			x= x /10 ;
		}
		//�����ֳ���Ϊ����ʱ�����ǿ���ͨ�� revertedNumber/10 ȥ��������λ�����֡�
        // ���磬������Ϊ 12321 ʱ���� while ѭ����ĩβ���ǿ��Եõ� x = 12��revertedNumber = 123��
        // ���ڴ�����λ�����ֲ�Ӱ����ģ����������Լ���ȣ����������ǿ��Լ򵥵ؽ���ȥ����
		return x == revertedNumber || x == revertedNumber/10;
	}
}
