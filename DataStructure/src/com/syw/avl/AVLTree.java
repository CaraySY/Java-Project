package com.syw.avl;

/**
 * 	 	ƽ�������(AVL Tree)��+����ת+��[��������������(�������ĸ߶� - �������ĸ߶�)  > 1] <br>
 * ->����һ���µĽ�㣬��ֵ���ڸ�����ֵ��value=root.value <br>
 * ->���½�������������Ϊ��ǰ������������newNode.left=this.left <br>
 * ->���½�������������Ϊ��ǰ��������������������newNode.right=this.right.left <br>
 * ->�ѵ�ǰ����ֵ�滻Ϊ���ӽ���ֵ:this.value=this.right.value <br>
 * ->�ѵ�ǰ��������������Ϊ���������������� this.right=this.right.right <br>
 * ->�ѵ�ǰ��������������Ϊ�½�㣺this.left=newLeft <br>
 * 
 *		++++++++++++++���[*��ǰ������������������*]�ĸ߶ȴ���[*��ǰ�ڵ����������������*]�ĸ߶�+++++++++++++++
 *												-->�Ƚ�������ת-->����ת
 *		ƽ�������(AVL Tree)��+����ת+��[��������������(�������ĸ߶� - �������ĸ߶�)  > 1] <br>
 * ->����һ���µĽ�㣬��ֵ���ڸ�����ֵ��value=root.value <br>
 * ->���½�������������Ϊ��ǰ������������newNode.right=this.right <br>
 * ->���½�������������Ϊ��ǰ��������������������newNode.left=this.left.right <br>
 * ->�ѵ�ǰ����ֵ�滻Ϊ���ӽ���ֵ:this.value=this.left.value <br>
 * ->�ѵ�ǰ��������������Ϊ���������������� this.left=this.left.left <br>
 * ->�ѵ�ǰ��������������Ϊ�½�㣺this.right=newLeft <br>
 * 		++++++++++++++���[*��ǰ������������������*]�ĸ߶ȴ���[*��ǰ�ڵ����������������*]�ĸ߶�+++++++++++++++
 * 												-->�Ƚ�������ת-->����ת
 * 
 * @author Administrator
 *
 */
public class AVLTree {

	private Node root;
	
	public void add(int value) {
		
		Node node=new Node(value);
		if(root==null) {
			root=node;
		}else {
			root.add(node); //��ӽڵ�
		}
	}

	public Node getRoot() {

		return root;
	}
	
	public void infixOrder() {
		
		if(this.root!=null) {
			this.root.infixOrder();
		}else {
			System.out.println("������Ϊ��,�޷�����");
		}
	}
	
	/**
	 * 	���ڵ����߶�
	 * @return
	 */
	public int getRootHeigh() {
		
		if(this.root!=null) {
			return this.root.height();
		}else {
			throw new RuntimeException("������Ϊ��,�߶�Ϊ0...");
		}
	}
	
	public int getRightHeight() {
		
		if(this.root!=null) {
			return this.root.rightHeight();
		}else {
			throw new RuntimeException("������Ϊ��,�߶�Ϊ0...");
		}
	}
	
	public int getLeftHeight() {
		
		if(this.root!=null) {
			return this.root.leftHeight();
		}else {
			throw new RuntimeException("������Ϊ��,�߶�Ϊ0...");
		}
	}
	
	private class Node {

		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}

		/**
		 * ��ӽڵ�
		 */
		public void add(Node node) {

			if (node == null) {
				return;
			}
			// �жϵ�ǰ�ڵ�������ӽڵ�Ĺ�ϵ
			if (this.value > node.value) { // ��ӵĽڵ�С�ڸ��ڵ�,��ݹ�
				if (this.left == null) {
					this.left = node;// ��һ����ӣ����ӽڵ�Ϊ�գ�ֱ�Ӽ���
				} else {
					// �ݹ�
					this.left.add(node);
				}
			} else {
				if (this.right == null) {
					this.right = node;
				} else { // �ҵݹ�
					this.right.add(node);
				}
			}
			//�������������ת
			if((rightHeight()-leftHeight() > 1)){
				leftRotate();
			}
			if((leftHeight()-rightHeight() > 1)) {
				rightRotate();
			}
		}
		
		/**
		 * 	����ת��
		 * 		���һ�ö�����������you�����ĸ߶ȴ����������ĸ߶ȣ���Ҫ��������ת
		 */
		private  void leftRotate() {
			
			//1������һ���½�㣬ֵ���ڸ����
			Node newNode=new Node(this.value);
			//2���½�������������ԭ��������������
			newNode.left=this.left;
			//3���½�������������ԭ����������������������
			newNode.right=this.right.left;
			//4��ԭ��������this��value���ҽڵ��value
			this.value=this.right.value;
			//5��ԭ��������������ָ���½��
			this.left=newNode;
			//6��ԭ��������������ָ����������������
			this.right=this.right.right;
		}

		/**
		 * 	����ת��
		 * 		���һ�ö������������������ĸ߶ȴ����������ĸ߶ȣ���Ҫ��������ת
		 * 
		 */
		private void rightRotate() {
			
			//1������һ���½�㣬ֵ���ڸ����
			Node newNode=new Node(this.value);
			//2���½���������ָ��ԭ��������������
			newNode.right=this.right;
			//3���½���������ָ��ԭ����������������������
			newNode.left=this.left.right;
			//4��ԭ��������rootֵΪ���ӽڵ�
			this.value=this.left.value;
			//5��ԭ��������������ָ���½��
			this.right=newNode;
			//6��ԭ��������������ָ����������������
			this.left=this.left.left;
		}
		
		/**
		 * �������
		 */
		public void infixOrder() {

			if (this.left != null) {
				this.left.infixOrder();
			}
			System.out.println(this);
			if (this.right != null) {
				this.right.infixOrder();
			}
		}

		public  int leftHeight() {
			
			if(this.left==null) {
				return 0;
			}
			return this.left.height();
		}
		
		public int rightHeight() {
			
			if(this.right==null) {
				return 0;
			}
			return this.right.height();
		}
		
		/**
		 * ���ص�ǰ���ĸ߶ȣ��Ըýڵ�Ϊ���������ĸ߶�
		 * @return
		 */
		public int height() {
			
			int leftHeight=0;
			int rightHeight=0;
			if(this.left!=null) {
				leftHeight=this.left.height();
			}
			if(this.right!=null) {
				rightHeight=this.right.height();
			}
			return Math.max(leftHeight, rightHeight)+1;
		}
		
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}
}
