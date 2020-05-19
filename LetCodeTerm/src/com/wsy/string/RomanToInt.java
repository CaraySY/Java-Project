package com.wsy.string;

/**
 * 	����Ϸ���һ���������֣�ת��int
 * @author Administrator
 *
 */
public class RomanToInt {

	public static void main(String[] args) {
		
		int res=romanToInt("MCMXCIV");
		System.out.println("res="+res);
	}
	
	/**
	 * 	���������� I,V,X,L,C,D,M ����;
	 *	��Сֵ�ڴ�ֵ����ߣ����Сֵ���� IV=5-1=4;
	 *	��Сֵ�ڴ�ֵ���ұߣ����Сֵ���� VI=5+1=6;
	 *	���Ͽ�֪����ֵ��ԶΪ����������һλ��ȻΪ����
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s) {
		
		int sum=0;
		char[] ps=s.toCharArray();
		//��ȡ��һ�������ַ���Ӧ������ֵ
		int preNum=getVal(ps[0]);
		for(int i=1;i<ps.length;i++) { //�ӵ�һ�������ַ���ʼ����
			int num=getVal(ps[i]);//��һ���ַ�
			if(num>preNum) { //�Ƚϵ�ǰ�ַ��ϴ���ǰһ���ַ��ϴ󣬵�ǰ���ȥ
				sum=sum-preNum;
			}else {
				sum=sum+preNum;//С�ڣ�����
			}
			preNum=num;//�ѵ�ǰֵ��Ϊǰһ��
		}
		sum+=preNum; //�������һ�������ַ�
		return sum;
	}
	
	/**
	 * 	    case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
	 * @param c
	 * @return
	 */
	private static int getVal(char c) {
		
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default: 
			return 0;
		}
	}
}
