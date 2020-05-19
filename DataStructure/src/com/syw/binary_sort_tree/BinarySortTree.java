package com.syw.binary_sort_tree;

/**
 * 	���������� BST
 * 
 * 	����������ɾ����㣺
 * +��һ�������[ɾ��Ҷ�ӽڵ�]
 * 1����Ҫ��ȥ�ҵ�Ҫɾ���Ľ�㣬targetNode
 * 2���ҵ�targetNode�ĸ��ڵ�
 * 3��ȷ��targetNode��parent����/���ӽڵ�
 * 4������ǰ����������Ӧɾ��
 * 	4.1 targetNode��parent�����ӽڵ㣺parent.left=null
 * 	4.2 targetNode��parent�����ӽڵ㣺parent.right=null
 * +�ڶ��������[ɾ��ֻ��һ�������Ľڵ�]
 * 	1����Ҫ��ȥ�ҵ�Ҫɾ���Ľ�㣬targetNode
 *  2���ҵ�targetNode�ĸ��ڵ�
 *  3��ȷ��targetNode��+�ӽڵ�+��targetNode����/���ӽڵ�
 *  4��ȷ��targetNode��parent����/���ӽڵ�
 *  5�����targetNode�����ӽڵ�
 *   5.1 ���targetNode��parent�����ӽڵ�
 *   	 parent.left=targetNode.left
 *   5.2 ���targetNode��parent�����ӽڵ�
 *  	 parent.right=target.left
 *  6�����targetNode�����ӽڵ�
 *    6.1 ���targetNode��parent�����ӽڵ�
 *    	  parent.left=target.right
 *    6.2 ���targetNode��parent�����ӽڵ�
 *        parent.right=target.right
 * +���������:[ɾ�������������Ľڵ�]
 * 	1����Ҫ��ȥ�ҵ�Ҫɾ���Ľ�㣬targetNode
 *  2���ҵ�targetNode�ĸ��ڵ�
 *  3����targetNode����(��)�����ҵ���С�Ľڵ�
 *  4����һ����ʱ����������С(��)�Ľڵ��ֵ������temp
 *  5��ɾ������С(��)�ڵ�
 *  6��targetNode.value=temp
 * @author Administrator
 *
 */
public class BinarySortTree {

	private Node root;
	
	public void add(int value) {
		
		Node node=new Node(value);
		if(root==null) {
			root=node;
		}else {
			root.add(node); //��ӽڵ�
		}
	}
	
	/**
	 * 	ɾ�������������Ľ�㣺�������
	 * @param value ɾ����ǰ�ڵ��ֵ 
	 */
	public void delNode(int value) {
		
		
		if(root==null) { //���ڵ�Ϊ��ֱ�ӷ���
			return;
		}
		//1����Ҫ��ȥ�ҵ�Ҫɾ���Ľ�㣬targetNode
		Node target=search(value);
		if(target==null) {
			return;//û���ҵ�Ҫɾ���Ľڵ�
		}
		//Ҫɾ���Ľڵ�Ϊ���ڵ�ֱ��ɾ��
		if(root.left==null && root.right==null) { 
			root=null;
			return;
		}
		//2��ɾ���������������������  a.[ɾ��Ҷ�ӽڵ� b.[ɾ��ֻ��һ�������Ľڵ� c.[ɾ�������������Ľڵ�
		//3���ҵ�targetNode�ĸ��ڵ�
		Node parent=searchParent(value);
		// a.[ɾ��Ҷ�ӽڵ�
		if(target.left==null && target.right==null) {
			//Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
			if(parent.left !=null && parent.left.value==value) {
				parent.left=null;
			}else { //Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
				parent.right=null;
			}
		// c.[ɾ�������������Ľڵ�
		}else if(target.left!=null && target.right!=null) {
			//��targetNode���������ҵ�ֵ��С�Ľڵ�
			//int min=getRightTreeMin(target.right);
			//target.value=min;
			//��targetNode���������ҵ�ֵ���Ľڵ�
			int max=getLeftTreeMax(target.left);
			target.value=max;
		//b.[ɾ��ֻ��һ�������Ľڵ� -->�����жϱȽϸ��ӣ��ŵ����
		}else {
			if(target.left !=null) { //ȷ��target���ӽڵ�����ڵ�
				//target�Ǹ��ڵ����ڵ�
				if(parent==null) { //--->��ֻʣ�¸��ڵ�ʱ��һ����������ɾ�����ڵ����ֿ�ָ��-->���ڵ��޸��ڵ�s
					root=target.left;
					
				}else {
					if(parent.left!=null && parent.left.value==value) {
						parent.left=target.left;
					}else { //target�Ǹ��ڵ���ҽڵ�
						parent.right=target.left;
					}
				}
			}else {  //ȷ��target���ӽڵ����ҽڵ�
				if(parent==null) {  //--->��ֻʣ�¸��ڵ�ʱ��һ����������ɾ�����ڵ����ֿ�ָ��-->���ڵ��޸��ڵ�s
					root=target.right;
				}else {
					//target�Ǹ��ڵ����ڵ�
					if(parent.left!=null && parent.left.value==value) {
						parent.left=target.right;
					}else { //target�Ǹ��ڵ���ҽڵ�
						parent.right=target.right;
					}
				}
			}
		}
	}
	
	/**
	 * 	��targetΪ���ڵ㣬���в�������ֵ
	 * @param target
	 * @return ����ɾ���ڵ��ֵ
	 */
	private int getLeftTreeMax(Node target) {

		Node temp=target;
		while(temp.right!=null) {
			temp=temp.right;
		}
		int res=temp.value;
		delNode(res);
		return res;
	}

	/**
	 * 	��targetΪ���ڵ㣬�ҵ���Сֵ-->һֱ������Ѱ
	 * @param target ��ǰ�ڵ�
	 * @return Ҫɾ���ڵ������������С�ڵ��ֵ
	 */
	@SuppressWarnings("unused")
	private int getRightTreeMin(Node target) {

		Node temp=target;//�Ե�ǰ�ڵ�Ϊ���ڵ㣬�����ѯ�ҵ���С��ֵ 
		while(temp.left!=null) { // ��������������ڵ�����С���м�ڵ���ҽڵ�
			temp=temp.left;
		}
		int res=temp.value;
		delNode(res); //ɾ����ǰ��Сֵ�ڵ�
		return res; //������Сֵ��value
	}

	private Node search(int value) {
		
		if(root==null) {
			System.out.println("������Ϊ�գ��޷����ҡ�����");
			return null;
		}else {
			return root.search(value);
		}
	}
	
	private Node searchParent(int value) {
		
		if(root==null) {
			System.out.println("������Ϊ�գ��޷����ҡ�����");
			return null;
		}else {
			return root.searchParent(value);
		}
	}

	public void infixOrder() {
		
		if(this.root!=null) {
			this.root.infixOrder();
		}else {
			System.out.println("������Ϊ��,�޷�����");
		}
	}
	
	public Node getRoot() {
		return root;
	}

	/**
	 * 	���Ų��������ڵ㶨��
	 * @author Administrator
	 *
	 */
	private class Node{
		
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value = value;
		}

		/**
		 * 	��ӽڵ�
		 */
		public void add(Node node) {
			
			if(node==null) {
				return;
			}
			//�жϵ�ǰ�ڵ�������ӽڵ�Ĺ�ϵ
			if(this.value > node.value) { //��ӵĽڵ�С�ڸ��ڵ�,��ݹ�
				if(this.left==null) {
					this.left=node;//��һ����ӣ����ӽڵ�Ϊ�գ�ֱ�Ӽ���
				}else {
					//�ݹ�
					this.left.add(node);
				}
			}else { 
				if(this.right==null) {
					this.right=node;
				}else { //�ҵݹ�
					this.right.add(node);
				}
			}
		}
		
		/**
		 * 	���ҵ�ǰҪɾ���Ľڵ�
		 * @param value ���ҵ�ǰ�ڵ��value
		 * @return ���ز��ҵ��ĵ�ǰ�ڵ�
		 */
		public Node search(int value) {
			
			if(this.value==value) { //�ҵ���ǰ�ڵ�
				return this;
			}else if(this.value > value) { //���ҵĽڵ�С�ڵ�ǰ�ڵ�
				if(this.left!=null) {
					return this.left.search(value);
				}else {
					return null;
				}
			}else { //���ҵĽڵ���ڵ�ǰ�ڵ�
				if(this.right != null) {
					return this.right.search(value);
				}else {
					return null;
				}
			}
		}
		
		/**
		 * 	���ҵ�ǰ�ڵ�ĸ��ڵ�
		 * @param value
		 * @return ������Ҫɾ���ڵ�ĸ��ڵ�
		 */
		public Node searchParent(int value) {
			
			if((this.left!=null && this.left.value==value) 
					|| (this.right!=null && this.right.value==value)) {
				return this;//�ҵ��˵�ǰ�ڵ�
			}else{
				if(this.value > value && this.left!=null) {//��ݹ�
					return this.left.searchParent(value);
				}else if(this.value <= value && this.right!=null) { //�ҵݹ�
					return this.right.searchParent(value);
				}else {
					return null;//���ؿմ����Ҳ������ڵ���Ϣ
				}
			}
		}
		
		/**
		 * 	�������
		 */
		public void infixOrder() {
			
			if(this.left!=null) {
				this.left.infixOrder();
			}
			System.out.println(this);
			if(this.right!=null) {
				this.right.infixOrder();
			}
		}
		
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}
}
