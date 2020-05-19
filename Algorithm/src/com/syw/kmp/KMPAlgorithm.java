package com.syw.kmp;

/**
 * 	KMP算法的next数组(部分匹配值数组)[部分匹配值->子字符串的前后缀的最大公共长度]
 * @author Administrator
 *
 */
public class KMPAlgorithm {

	public static void main(String[] args) {
		
		String str1="BBC ABCDAB ABCDABCDABDE";
		String str2="ABCDABD";
		int index = kMPAlgorithm(str1,str2);
		System.out.println("index="+index);
	}
	
	public static int kMPAlgorithm(String str1,String str2){
		
		char[] t=str1.toCharArray();
		char[] p=str2.toCharArray();
		int i=0; //主串位置
		int j=0; //模式串位置
		int[] next=getNext(str2);
		
		while(i<t.length && j<p.length) {
			if(j==-1 || t[i]==p[j]) {
				//如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++，继续匹配下一个字符
				i++;
				j++;
			}else {
				/**
				 * 如果j != -1，且当前字符匹配失败（即S[i] != P[j]）
				 * 则令 i 不变，j = next[j]。
				 * 此举意味着失配时，模式串P相对于文本串S
				 * 向右移动了j - next [j] 位 并且值大于或者是等于1
				 */
				j=next[j];
			}
		}
		//j的值等于模式串的长度即为匹配成功
		if(j==p.length) {
			return i-j;
		}else {
			return -1;
		}
	}
	
	/**
	 * 	Next 数组不包括当前字符的最长公共子字符串的Len
	 * @param ps
	 * @return
	 */
	public static int[] getNext(String ps) {
		
		int[] next=new int[ps.length()];
		char[] p=ps.toCharArray();
		
		int j=0;
		int k=-1;  // k就是j指向当前字符串(不包括自己)的前后缀最大公共长度
		next[0]=-1; //初始值为-1
		while(j < p.length-1) { 

			// p[k] 表示前缀，p[j]表示后缀
			if(k==-1 || p[k]==p[j]) {
				//优化 getNext
				// 当p[j] != s[i] 时，
				//下次匹配必然是p[ next [j]] 跟s[i]匹配，如果p[j] = p[ next[j] ]，
				//必然导致后一步匹配失败
				//因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，
				//k = next[k] = next[next[k]]  
				++j;
				++k;
				if(p[j]!=p[k]) {
					next[j]=k;
				}else {
					//k继续向前递归
					next[j]=next[k];
				}
                next[j] = next[k];
			}else {

				// 若p[k ] ≠ p[j]，如果此时p[ next[k] ] == p[j ]，
				// 则前缀向前递归找到一个
				// 能够使：next[ j + 1 ] =  next[k] + 1，否则继续递归前缀索引k = next[k]，
				// 而后重复此过程
				//找不到 其next值就为 0
				k=next[k]; 
				//为何递归前缀索引k = next[k]，就能找到长度更短的相同前缀后缀呢?
				/**
				 * 这又归根到next数组的含义。我们拿前缀 p0 pk-1 pk 去跟后缀pj-k pj-1 pj匹配，
				 * 如果pk 跟pj 失配，下一步就是用p[next[k]] 去跟pj 继续匹配，
				 * 如果p[ next[k] ]跟pj还是不匹配，
				 * 则需要寻找长度更短的相同前缀后缀，
				 * 即下一步用p[ next[ next[k] ] ]去跟pj匹配。
				 * 此过程相当于模式串的自我匹配，所以不断的递归k = next[k]，
				 * 直到要么找到长度更短的相同前缀后缀，要么没有长度更短的相同前缀后缀->为 0
				 */
			}
		}
		return next;
	}
}
