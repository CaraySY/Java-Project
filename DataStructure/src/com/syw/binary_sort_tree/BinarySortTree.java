package com.syw.binary_sort_tree;

/**
 * 	二叉排序树 BST
 * 
 * 	二叉排序树删除结点：
 * +第一种情况：[删除叶子节点]
 * 1、需要先去找到要删除的结点，targetNode
 * 2、找到targetNode的父节点
 * 3、确定targetNode是parent的左/右子节点
 * 4、根据前面的情况来对应删除
 * 	4.1 targetNode是parent的左子节点：parent.left=null
 * 	4.2 targetNode是parent的右子节点：parent.right=null
 * +第二种情况：[删除只有一颗子树的节点]
 * 	1、需要先去找到要删除的结点，targetNode
 *  2、找到targetNode的父节点
 *  3、确定targetNode的+子节点+是targetNode的左/右子节点
 *  4、确定targetNode是parent的左/右子节点
 *  5、如果targetNode有左子节点
 *   5.1 如果targetNode是parent的左子节点
 *   	 parent.left=targetNode.left
 *   5.2 如果targetNode是parent的右子节点
 *  	 parent.right=target.left
 *  6、如果targetNode有右子节点
 *    6.1 如果targetNode是parent的左子节点
 *    	  parent.left=target.right
 *    6.2 如果targetNode是parent的右子节点
 *        parent.right=target.right
 * +第三种情况:[删除有两颗子树的节点]
 * 	1、需要先去找到要删除的结点，targetNode
 *  2、找到targetNode的父节点
 *  3、从targetNode的右(左)子树找到最小的节点
 *  4、用一个临时变量，将最小(大)的节点的值保存在temp
 *  5、删除该最小(大)节点
 *  6、targetNode.value=temp
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
			root.add(node); //添加节点
		}
	}
	
	/**
	 * 	删除二叉排序树的结点：三种情况
	 * @param value 删除当前节点的值 
	 */
	public void delNode(int value) {
		
		
		if(root==null) { //根节点为空直接返回
			return;
		}
		//1、需要先去找到要删除的结点，targetNode
		Node target=search(value);
		if(target==null) {
			return;//没有找到要删除的节点
		}
		//要删除的节点为父节点直接删除
		if(root.left==null && root.right==null) { 
			root=null;
			return;
		}
		//2、删除二叉排序树有三种情况  a.[删除叶子节点 b.[删除只有一颗子树的节点 c.[删除有两颗子树的节点
		//3、找到targetNode的父节点
		Node parent=searchParent(value);
		// a.[删除叶子节点
		if(target.left==null && target.right==null) {
			//要删除的节点是父节点的左子节点
			if(parent.left !=null && parent.left.value==value) {
				parent.left=null;
			}else { //要删除的节点是父节点的右子节点
				parent.right=null;
			}
		// c.[删除有两颗子树的节点
		}else if(target.left!=null && target.right!=null) {
			//从targetNode的右子树找到值最小的节点
			//int min=getRightTreeMin(target.right);
			//target.value=min;
			//从targetNode的左子树找到值最大的节点
			int max=getLeftTreeMax(target.left);
			target.value=max;
		//b.[删除只有一颗子树的节点 -->条件判断比较复杂，放到最后
		}else {
			if(target.left !=null) { //确定target的子节点是左节点
				//target是父节点的左节点
				if(parent==null) { //--->当只剩下根节点时和一颗左子树，删除根节点会出现空指针-->根节点无父节点s
					root=target.left;
					
				}else {
					if(parent.left!=null && parent.left.value==value) {
						parent.left=target.left;
					}else { //target是父节点的右节点
						parent.right=target.left;
					}
				}
			}else {  //确定target的子节点是右节点
				if(parent==null) {  //--->当只剩下根节点时和一颗右子树，删除根节点会出现空指针-->根节点无父节点s
					root=target.right;
				}else {
					//target是父节点的左节点
					if(parent.left!=null && parent.left.value==value) {
						parent.left=target.right;
					}else { //target是父节点的右节点
						parent.right=target.right;
					}
				}
			}
		}
	}
	
	/**
	 * 	以target为根节点，向有查找最大的值
	 * @param target
	 * @return 返回删除节点的值
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
	 * 	以target为根节点，找到最小值-->一直向左搜寻
	 * @param target 当前节点
	 * @return 要删除节点的右子树的最小节点的值
	 */
	@SuppressWarnings("unused")
	private int getRightTreeMin(Node target) {

		Node temp=target;//以当前节点为根节点，向左查询找到最小的值 
		while(temp.left!=null) { // 二叉排序树的左节点总是小于中间节点和右节点
			temp=temp.left;
		}
		int res=temp.value;
		delNode(res); //删除当前最小值节点
		return res; //返回最小值的value
	}

	private Node search(int value) {
		
		if(root==null) {
			System.out.println("二叉树为空，无法查找。。。");
			return null;
		}else {
			return root.search(value);
		}
	}
	
	private Node searchParent(int value) {
		
		if(root==null) {
			System.out.println("二叉树为空，无法查找。。。");
			return null;
		}else {
			return root.searchParent(value);
		}
	}

	public void infixOrder() {
		
		if(this.root!=null) {
			this.root.infixOrder();
		}else {
			System.out.println("二叉树为空,无法遍历");
		}
	}
	
	public Node getRoot() {
		return root;
	}

	/**
	 * 	二号叉排序树节点定义
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
		 * 	添加节点
		 */
		public void add(Node node) {
			
			if(node==null) {
				return;
			}
			//判断当前节点和左右子节点的关系
			if(this.value > node.value) { //添加的节点小于根节点,左递归
				if(this.left==null) {
					this.left=node;//第一次添加，左子节点为空，直接加入
				}else {
					//递归
					this.left.add(node);
				}
			}else { 
				if(this.right==null) {
					this.right=node;
				}else { //右递归
					this.right.add(node);
				}
			}
		}
		
		/**
		 * 	查找当前要删除的节点
		 * @param value 查找当前节点的value
		 * @return 返回查找到的当前节点
		 */
		public Node search(int value) {
			
			if(this.value==value) { //找到当前节点
				return this;
			}else if(this.value > value) { //查找的节点小于当前节点
				if(this.left!=null) {
					return this.left.search(value);
				}else {
					return null;
				}
			}else { //查找的节点大于当前节点
				if(this.right != null) {
					return this.right.search(value);
				}else {
					return null;
				}
			}
		}
		
		/**
		 * 	查找当前节点的父节点
		 * @param value
		 * @return 返回需要删除节点的父节点
		 */
		public Node searchParent(int value) {
			
			if((this.left!=null && this.left.value==value) 
					|| (this.right!=null && this.right.value==value)) {
				return this;//找到了当前节点
			}else{
				if(this.value > value && this.left!=null) {//左递归
					return this.left.searchParent(value);
				}else if(this.value <= value && this.right!=null) { //右递归
					return this.right.searchParent(value);
				}else {
					return null;//返回空代表找不到父节点信息
				}
			}
		}
		
		/**
		 * 	中序遍历
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
