package com.syw.tree;

import java.util.Stack;

/**
 * 	定义ThreadBinaryTree 实现了线索化功能的二叉树
 * 作业：线索化二叉树前序、后序需要完成
 * @author Administrator
 *
 */
public class ThreadedBinaryTree {

	private HeroNode root=new HeroNode(1, "Tom");
	
	//为了省市县线索化，需要创建一个指向当前节点到达的前驱节点
	//因为二叉树的查询是单向的，需要保存前一个节点的信息才能实现线索化
	private HeroNode prev;
	
	// 手动创建二叉树
	
	HeroNode node2 = new HeroNode(3, "Jackey");
	HeroNode node3 = new HeroNode(6, "Smith");
	HeroNode node4 = new HeroNode(8, "Mary");
	HeroNode node5 = new HeroNode(10, "King");
	HeroNode node6 = new HeroNode(14, "Dim");
	
	public void init() {
		//手动创建二叉树
		root.left=node2;
		root.right=node3;
		node2.left=node4;
		node2.right=node5;
		node3.left=node6;
	}
	
	public void test() {
		System.out.println("10号前驱节点是"+node5.left);
		System.out.println("10号后继节点是"+node5.right);
	}
	
	public void threadedTreeByInfix() {
		
		if(root==null) {
			System.out.println("二叉树为空...");
			return;
		}
		threadedTreeByInfix(root);
	}
	
	public void threadedTreeByPre() {
		
		if(root==null) {
			System.out.println("二叉树为空...");
			return;
		}
		threadedTreeByPre(root);
	}
	
	public void threadedTreeByPost() {
		
		if(root==null) {
			System.out.println("二叉树为空...");
			return;
		}
		threadedTreeByPost(root);
	}
	
	public void printThreadedTreeByPost() {
		
		if(root==null) {
			System.out.println("二叉树为空...");
			return;
		}
		printThreadedTreeByPost(root);
	}
	
	/**
	 * 	后序遍历二叉树，因为不是全部连续，需要保存根节点。但会无限循环。。
	 * @param node
	 */
	private void printThreadedTreeByPost(HeroNode node) {

		Stack<HeroNode> stack=new Stack<HeroNode>();
		stack.push(node.right);
		while(node!=null) {
			
			if(stack.size() >0 ) {
				while(node.leftType==0) {
					node=node.left;
				}
				System.out.println(node);
				node=node.right;
				while(node!=null && node.rightType==1) {
					System.out.println(node);
					node=node.right;
				}
				System.out.println(node);
				node=stack.pop();
			}
		}
	}

	public void printThreadedTreeByPre() {
		
		if(root==null) {
			System.out.println("二叉树为空...");
			return;
		}
		printThreadedTreeByPre(root);
	}
	
	/**
	 * 	前序遍历线索化二叉树
	 * @param node
	 */
	private void printThreadedTreeByPre(HeroNode node) {
		
		while(node!=null) {
			System.out.println(node); //直接输出当前节点
			while(node.leftType==0) { //直接向左搜寻到第一个有指向前驱节点的当前节点
				node=node.left;
				System.out.println(node);
			}
			//切换到右指针
			node=node.right;
			while(node!=null && node.rightType==1) { //循环输出有指向后继节点的当前节点
				System.out.println(node);
				node=node.right;
			}
		}
	}
	
	/**
	 * 	使用中序线索化二叉树
	 * @param node
	 */
	private void threadedTreeByPre(HeroNode node) {
		
		if(node==null) {
			return;
		}
		/*将当前节点线索化*/
		if(node.left==null) {
			node.left=prev;//指向前驱节点
			node.leftType=1;
		}
		/*当前节点的后继指向，应该由下一个节点指向当前节点 [下一个节点不为空]*/
		if(prev!=null && prev.right==null) {
			prev.right=node;
			prev.rightType=1;
		}
		prev=node; //当前节点设置为前驱节点
		if(node.leftType==0) { //判断当前节点是否还有左子节点
			threadedTreeByPre(node.left); 
		}
		if(node.rightType==0) { //判断当前节点是否还有右子节点
			threadedTreeByPre(node.right); 
		}
	} 
	
	/**
	 * 	线索化二叉树方法 [中序线索化]
	 * @param node 需要线索化的节点
	 */
	private void threadedTreeByInfix(HeroNode node) {
		
		if(node==null) { //当前节点为空不需要线索化
			return;
		}
		
		/*处理当前指针的线索化*/
		if(node.left==null) {
			node.left=prev; //让当前节点的左指针指向前驱节点
			node.leftType=1;//修改指向类型 1 前驱结点 0  左子树
		}
		
		/*由于二叉树是单向递归，需要当前节点的后继指向当前节点实现当前节点的线索化*/
		if(prev!=null && prev.right==null) { //保证前驱节点不为空且其右子节点为空，才能指向node
			//前驱节点的右指针指向当前节点
			prev.right=node;
			prev.rightType=1;  //修改指向类型 1 后继结点 0  右子树
		}
		//!!! 每次处理一个节点后，让当前节点是下一个节点的前驱节点
		prev=node;
		//当前节点的右指针递归进行线索化
		if(node.leftType==0) {
			threadedTreeByInfix(node.left);
		}
		if(node.rightType==0) {
			threadedTreeByInfix(node.right);
		}
	}
	
	private void threadedTreeByPost(HeroNode node) {
		
		if(node==null) {
			return;//递归退出条件
		}
		if(node.leftType==0) {//左递归
			threadedTreeByPost(node.left);
		}
		if(node.rightType==0) {
			threadedTreeByPost(node.right);
		}
		/*处理当前指针的线索化*/
		if(node.left==null) {
			node.left=prev; //让当前节点的左指针指向前驱节点
			node.leftType=1;//修改指向类型 1 前驱结点 0  左子树
		}
		
		/*由于二叉树是单向递归，需要当前节点的后继指向当前节点实现当前节点的线索化*/
		if(prev!=null && prev.right==null) { //保证前驱节点不为空且其右子节点为空，才能指向node
			//前驱节点的右指针指向当前节点
			prev.right=node;
			prev.rightType=1;  //修改指向类型 1 后继结点 0  右子树
		}
		//!!! 每次处理一个节点后，让当前节点是下一个节点的前驱节点
		prev=node;
	}
	
	/**
	 * 	从Root根节点遍历线索二叉树
	 */
	public void printThreadedBinaryTree() {
		
		HeroNode node=root;//辅助指针帮助我们遍历线索二叉树
		while(node!=null) { //当前节点不为空，循环输出
			while(node.leftType==0) { //循环找到第一个有后继节点的指针
				//当leftType=1，说明该节点是按照线索化的
				node=node.left; 
			}
			//直接输出第一有后继节点指针的值
			System.out.println(node);
			while(node.rightType==1){ //当前节点的右指针指向前驱节点，一直输出
				node=node.right;
				System.out.println(node);
			}
			node=node.right;//切换节点类型
		}
	}
	
	
	/**
	 * 	线索化二叉树， node节点的
	 * 			左子节点可以指向左子树或者是前驱节点
	 * 			右子节点可以指向右子树或者是后继节点
	 * @author Administrator
	 *
	 */
	private class HeroNode {

		private int no;
		private String name;
		private HeroNode left; //左子节点
		private HeroNode right; //右子节点
		
		// leftType=0-->指向左子树
		// leftType=1-->指向前驱节点
		private int leftType;
		// rightType=0-->指向右子树
		// rightType=1-->指向后继节点
		private int rightType;

		public HeroNode(int no, String name) {

			this.no = no;
			this.name = name;
		}

		@Override
		public String toString() {
			return "HeroNode [no=" + no + ", name=" + name + "]";
		}
	}
}
