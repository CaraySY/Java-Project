package com.syw.tree;

/**
 * 	1��˳�������ֻ������ȫ������ [ʹ������ʵ��]
 * 	2����n��Ԫ�ص����ӽڵ㣺2*n+1
 * 	3����n��Ԫ�ص����ӽڵ㣺2*n+2
 * 	4����n��Ԫ�صĸ��׽ڵ㣺(n-1)/2
 * 	5��[nָ������������±�]
 * @author Administrator
 *
 */
public class SeqTree {

	private int[] tree;
	
	public SeqTree() {
		
		tree=new int[7];
		for(int i=0;i<7;i++) {
			tree[i]=(i+1);
		}
	}
	
	public void preOrder() {
		
		preOrder(0);
	}
	
	/**
	 * 	ǰ�����
	 * @param index �����±�
	 */
	private void preOrder(int index) {
		
		if(tree==null && tree.length==0) {
			System.out.println("����Ϊ�գ��޷����ж������ı���...");
			return;
		}
		System.out.print(tree[index]+" ");
		if(tree.length > 2*index+1) { //�����±������ݹ�
			preOrder(2*index+1);		
		}
		if(tree.length > 2*index+2) {
			preOrder(2*index+2);
		}
	}
	
	public void infixOrder() {
		
		infixOrder(0);
	}
	
	public void postOrder() {
		
		postOrder(0);
	}
	
	/**
	 * 	�������
	 * @param index
	 */
	private void infixOrder(int index) {
		
		if(tree==null && tree.length==0) {
			System.out.println("����Ϊ�գ��޷����ж������ı���...");
			return;
		}
		if(tree.length > 2*index+1) { //�����±������ݹ�
			infixOrder(2*index+1);		
		}
		System.out.print(tree[index]+" ");
		if(tree.length > 2*index+2) {
			infixOrder(2*index+2);
		}
	}
	
	private void postOrder(int index) {
		
		if(tree==null && tree.length==0) {
			System.out.println("����Ϊ�գ��޷����ж������ı���...");
			return;
		}
		if(tree.length > 2*index+1) { //�����±������ݹ�
			postOrder(2*index+1);		
		}
		if(tree.length > 2*index+2) {
			postOrder(2*index+2);
		}
		System.out.print(tree[index]+" ");
	}
}
