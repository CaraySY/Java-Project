package com.syw.kmp;

/**
 * 	KMP�㷨��next����(����ƥ��ֵ����)[����ƥ��ֵ->���ַ�����ǰ��׺����󹫹�����]
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
		int i=0; //����λ��
		int j=0; //ģʽ��λ��
		int[] next=getNext(str2);
		
		while(i<t.length && j<p.length) {
			if(j==-1 || t[i]==p[j]) {
				//���j = -1�����ߵ�ǰ�ַ�ƥ��ɹ�����S[i] == P[j]��������i++��j++������ƥ����һ���ַ�
				i++;
				j++;
			}else {
				/**
				 * ���j != -1���ҵ�ǰ�ַ�ƥ��ʧ�ܣ���S[i] != P[j]��
				 * ���� i ���䣬j = next[j]��
				 * �˾���ζ��ʧ��ʱ��ģʽ��P������ı���S
				 * �����ƶ���j - next [j] λ ����ֵ���ڻ����ǵ���1
				 */
				j=next[j];
			}
		}
		//j��ֵ����ģʽ���ĳ��ȼ�Ϊƥ��ɹ�
		if(j==p.length) {
			return i-j;
		}else {
			return -1;
		}
	}
	
	/**
	 * 	Next ���鲻������ǰ�ַ�����������ַ�����Len
	 * @param ps
	 * @return
	 */
	public static int[] getNext(String ps) {
		
		int[] next=new int[ps.length()];
		char[] p=ps.toCharArray();
		
		int j=0;
		int k=-1;  // k����jָ��ǰ�ַ���(�������Լ�)��ǰ��׺��󹫹�����
		next[0]=-1; //��ʼֵΪ-1
		while(j < p.length-1) { 

			// p[k] ��ʾǰ׺��p[j]��ʾ��׺
			if(k==-1 || p[k]==p[j]) {
				//�Ż� getNext
				// ��p[j] != s[i] ʱ��
				//�´�ƥ���Ȼ��p[ next [j]] ��s[i]ƥ�䣬���p[j] = p[ next[j] ]��
				//��Ȼ���º�һ��ƥ��ʧ��
				//��Ϊ���ܳ���p[j] = p[ next[j ]]�����Ե�����ʱ��Ҫ�����ݹ飬
				//k = next[k] = next[next[k]]  
				++j;
				++k;
				if(p[j]!=p[k]) {
					next[j]=k;
				}else {
					//k������ǰ�ݹ�
					next[j]=next[k];
				}
                next[j] = next[k];
			}else {

				// ��p[k ] �� p[j]�������ʱp[ next[k] ] == p[j ]��
				// ��ǰ׺��ǰ�ݹ��ҵ�һ��
				// �ܹ�ʹ��next[ j + 1 ] =  next[k] + 1����������ݹ�ǰ׺����k = next[k]��
				// �����ظ��˹���
				//�Ҳ��� ��nextֵ��Ϊ 0
				k=next[k]; 
				//Ϊ�εݹ�ǰ׺����k = next[k]�������ҵ����ȸ��̵���ͬǰ׺��׺��?
				/**
				 * ���ֹ����next����ĺ��塣������ǰ׺ p0 pk-1 pk ȥ����׺pj-k pj-1 pjƥ�䣬
				 * ���pk ��pj ʧ�䣬��һ��������p[next[k]] ȥ��pj ����ƥ�䣬
				 * ���p[ next[k] ]��pj���ǲ�ƥ�䣬
				 * ����ҪѰ�ҳ��ȸ��̵���ͬǰ׺��׺��
				 * ����һ����p[ next[ next[k] ] ]ȥ��pjƥ�䡣
				 * �˹����൱��ģʽ��������ƥ�䣬���Բ��ϵĵݹ�k = next[k]��
				 * ֱ��Ҫô�ҵ����ȸ��̵���ͬǰ׺��׺��Ҫôû�г��ȸ��̵���ͬǰ׺��׺->Ϊ 0
				 */
			}
		}
		return next;
	}
}
