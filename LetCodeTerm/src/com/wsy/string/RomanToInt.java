package com.wsy.string;

/**
 * 	输入合法的一个罗马数字，转成int
 * @author Administrator
 *
 */
public class RomanToInt {

	public static void main(String[] args) {
		
		int res=romanToInt("MCMXCIV");
		System.out.println("res="+res);
	}
	
	/**
	 * 	罗马数字由 I,V,X,L,C,D,M 构成;
	 *	当小值在大值的左边，则减小值，如 IV=5-1=4;
	 *	当小值在大值的右边，则加小值，如 VI=5+1=6;
	 *	由上可知，右值永远为正，因此最后一位必然为正。
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s) {
		
		int sum=0;
		char[] ps=s.toCharArray();
		//获取第一个罗马字符对应的整型值
		int preNum=getVal(ps[0]);
		for(int i=1;i<ps.length;i++) { //从第一个罗马字符开始计算
			int num=getVal(ps[i]);//下一个字符
			if(num>preNum) { //比较当前字符较大还是前一个字符较大，当前大减去
				sum=sum-preNum;
			}else {
				sum=sum+preNum;//小于，加上
			}
			preNum=num;//把当前值作为前一个
		}
		sum+=preNum; //加上最后一个罗马字符
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
