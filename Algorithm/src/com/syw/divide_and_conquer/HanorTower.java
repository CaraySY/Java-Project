package com.syw.divide_and_conquer;

/**
 * 	��ŵ����һ�������㷨�ľ��䰸��
 * 	A  B  C  Ϊ��������
 * 		N �� ���ӵĸ���
 *   N=1  -> ��   a->c
 *   N=2  -> ��   a->b a->c b->c
 *   ...
 *   N > 2 �������������̣�������ֻ��һ����
 *   �ݹ���Եó� �� �����Ƚ������һ���̴�a�ŵ�b����������̴�a�ŵ�c�����b���̷ŵ�c [ a->b a->c b->c]
 * @author Administrator
 *
 */
public class HanorTower {

	public static void main(String[] args) {
		
		hanorTower(3,'A','B','C');
	}
	
	public static void hanorTower(int num,char a,char b,char c) {
		
		if(num==1) { //ֻ��һ���̵�ʱ��
			System.out.printf("��:%c -> %c\n",a,c);
		}else {
			//�����ϵ��µ� 1~N-1���̴ӣ�a->b
			hanorTower(num-1,a,c,b); // �磺3���̣���(a)1->c,(a)2->b,(c)2->b �����c�����ƶ���c
			//����n���̴ӣ�a->c
			System.out.printf("��:%c -> %c\n",a,c);
			//�����ϵ��µ� 1~N-1���̴ӣ�b->c
			hanorTower(num-1, b, a, c); //�磺3���̣���(b)1->a,(b)2->c,(a)1->c �����a�����ƶ���a
		}
	}
}
