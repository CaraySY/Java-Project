package com.wsy.string;

public class KMPStr {

	public static void main(String[] args) {
	
		String haystack="hello";
		String needle="ll";
		int index=strStr(haystack,needle);
		System.out.println("index="+index);
	}
	
	
	public static int strStr(String haystack,String needle) {
		
		if(needle.equals("")) {
			return 0;
		}
		int[] next=getNext(needle);
		char[] t=haystack.toCharArray();
		char[] p=needle.toCharArray();
		int i=0; //ָ��t
		int j=0; //ָ�� p
		while(i<t.length && j<p.length) {
			if(j==-1 || t[i]==p[j]) {
				i++;
				j++;
			}else {
				j=next[j]; //��ǰ�ݹ�
			}
		}
		if(j==p.length) {
			return i-j;
		}else {
			return -1;
		}
	}
	
	public static int[] getNext(String needle) {
		
		int[] next=new int[needle.length()];
		char[] p=needle.toCharArray();
		next[0]=-1; //��ʼ����0��nextΪ-1
		int k=-1; //k��next[j]��ֵ
		int j=0;
		while(j<p.length-1) {
			if(k==-1 || p[k]==p[j]) {
				next[++j]=++k; //p[j+1]=p[j]+1
			}else {
				k=next[k]; // ab_[K]c_ab_[J]c_ pk==pj p[j+1]=p[j]+1
				// else K=next[k] -->       d --> ��ǰ���� p[k]=p[j]���Ҳ���Ϊ 0
			}
		}
		return next;
	}
}
