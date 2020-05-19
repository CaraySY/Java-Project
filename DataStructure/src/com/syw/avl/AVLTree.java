package com.syw.avl;

/**
 * 	 	平衡二叉树(AVL Tree)的+左旋转+：[当二叉排序树的(右子树的高度 - 左子树的高度)  > 1] <br>
 * ->创建一个新的结点，其值等于根结点的值：value=root.value <br>
 * ->把新结点的左子树设置为当前结点的左子树：newNode.left=this.left <br>
 * ->把新结点的右子树设置为当前结点的右子树的左子树：newNode.right=this.right.left <br>
 * ->把当前结点的值替换为右子结点的值:this.value=this.right.value <br>
 * ->把当前结点的右子树设置为右子树的右子树： this.right=this.right.right <br>
 * ->把当前结点的左子树设置为新结点：this.left=newLeft <br>
 * 
 *		++++++++++++++如果[*当前结点的右子树的左子树*]的高度大于[*当前节点的右子树的右子树*]的高度+++++++++++++++
 *												-->先进行右旋转-->左旋转
 *		平衡二叉树(AVL Tree)的+右旋转+：[当二叉排序树的(左子树的高度 - 右子树的高度)  > 1] <br>
 * ->创建一个新的结点，其值等于根结点的值：value=root.value <br>
 * ->把新结点的右子树设置为当前结点的右子树：newNode.right=this.right <br>
 * ->把新结点的左子树设置为当前结点的左子树的右子树：newNode.left=this.left.right <br>
 * ->把当前结点的值替换为左子结点的值:this.value=this.left.value <br>
 * ->把当前结点的左子树设置为左子树的左子树： this.left=this.left.left <br>
 * ->把当前结点的右子树设置为新结点：this.right=newLeft <br>
 * 		++++++++++++++如果[*当前结点的左子树的右子树*]的高度大于[*当前节点的左子树的左子树*]的高度+++++++++++++++
 * 												-->先进行左旋转-->右旋转
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
			root.add(node); //添加节点
		}
	}

	public Node getRoot() {

		return root;
	}
	
	public void infixOrder() {
		
		if(this.root!=null) {
			this.root.infixOrder();
		}else {
			System.out.println("二叉树为空,无法遍历");
		}
	}
	
	/**
	 * 	根节点树高度
	 * @return
	 */
	public int getRootHeigh() {
		
		if(this.root!=null) {
			return this.root.height();
		}else {
			throw new RuntimeException("二叉树为空,高度为0...");
		}
	}
	
	public int getRightHeight() {
		
		if(this.root!=null) {
			return this.root.rightHeight();
		}else {
			throw new RuntimeException("二叉树为空,高度为0...");
		}
	}
	
	public int getLeftHeight() {
		
		if(this.root!=null) {
			return this.root.leftHeight();
		}else {
			throw new RuntimeException("二叉树为空,高度为0...");
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
		 * 添加节点
		 */
		public void add(Node node) {

			if (node == null) {
				return;
			}
			// 判断当前节点和左右子节点的关系
			if (this.value > node.value) { // 添加的节点小于根节点,左递归
				if (this.left == null) {
					this.left = node;// 第一次添加，左子节点为空，直接加入
				} else {
					// 递归
					this.left.add(node);
				}
			} else {
				if (this.right == null) {
					this.right = node;
				} else { // 右递归
					this.right.add(node);
				}
			}
			//插入结点结束，旋转
			if((rightHeight()-leftHeight() > 1)){
				leftRotate();
			}
			if((leftHeight()-rightHeight() > 1)) {
				rightRotate();
			}
		}
		
		/**
		 * 	左旋转：
		 * 		如果一棵二叉排序树的you子树的高度大于左子树的高度，需要进行左旋转
		 */
		private  void leftRotate() {
			
			//1、创建一个新结点，值等于根结点
			Node newNode=new Node(this.value);
			//2、新结点的左子树等于原二叉树的左子树
			newNode.left=this.left;
			//3、新结点的右子树等于原二叉树的右子树的左子树
			newNode.right=this.right.left;
			//4、原二叉树的this的value的右节点的value
			this.value=this.right.value;
			//5、原二叉树的左子树指向新结点
			this.left=newNode;
			//6、原二叉树的右子树指向右子树的右子树
			this.right=this.right.right;
		}

		/**
		 * 	右旋转：
		 * 		如果一棵二叉排序树的左子树的高度大于右子树的高度，需要进行右旋转
		 * 
		 */
		private void rightRotate() {
			
			//1、创建一个新结点，值等于根结点
			Node newNode=new Node(this.value);
			//2、新结点的右子树指向原二叉树的右子树
			newNode.right=this.right;
			//3、新结点的左子树指向原二叉树的左子树的右子树
			newNode.left=this.left.right;
			//4、原二叉树的root值为左子节点
			this.value=this.left.value;
			//5、原二叉树的右子树指向新结点
			this.right=newNode;
			//6、原二叉树的左子树指向左子树的左子树
			this.left=this.left.left;
		}
		
		/**
		 * 中序遍历
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
		 * 返回当前结点的高度，以该节点为根结点的数的高度
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
