package com.syw.kmp;

/**
 * 	����ƥ���ַ����㷨
 * @author Administrator
 *
 */
public class ViolentMatchString {

	public static void main(String[] args) {
		
		int index=violentMatchString();
		System.out.println(index);
	}
	
	/**
	 *  @return
	 * 	���ص�һ��ƥ�䵽�ַ������±꣬���򷵻�-1
	 */
	public static int violentMatchString() {
		
		String str1="I love ChinaI love China I love ChinaChina";
		String str2="I love ChinaChina";
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int i=0; //ָ��str1
		int j=0; //ָ��str2
		
		while(i<s1.length && j<s2.length) {
			
			if(s1[i]==s2[j]) {
				i++;
				j++; //���ƥ�䵽��ͬ���ַ���ͬʱ�ƶ�ָ�� i,j����һ���ַ�
			}else {
				i=i-j+1; //ԭ�ַ���ָ����ݵ����ַ���ָ��  i ƥ�����һ���ַ�
				j=0;//���ַ���ָ������
			}
		}
		//�ж��Ƿ�ƥ��ɹ�  jָ����� s2�ַ����ĳ���
		if(j==s2.length) {
			return i-j; //���ص�һ�����ַ������ֵ�λ��
		}
		return -1;
	}
}
