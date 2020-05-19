package com.syw.tree;

public class BinaryTree {

	private HeroNode root;
	
	public BinaryTree() {
		
	}
	
	public void init() {
		//手动创建二叉树
		HeroNode node1=new HeroNode(1,"宋江");
		HeroNode node2=new HeroNode(2,"吴用");
		HeroNode node3=new HeroNode(3,"卢俊义");
		HeroNode node4=new HeroNode(4,"林冲");
		HeroNode node5=new HeroNode(5,"关胜");
		root=node1;
		node1.left=node2;
		node1.right=node3;
		node3.right=node4;
		node3.left=node5;
	}
	
	public void delNode(int no) {
		
		if(this.root==null) {
			System.out.println("二叉树为空，无法删除");
		}else {
			if(this.root.no==no) {
				this.root=null; //删除的节点是根节点，将整颗二叉树删除
			}
			this.root.delNode(no);
		}
	}
	
	
	
	public void preOrder() {
		
		if(this.root==null) {
			System.out.println("二叉树为空，无法遍历");
		}else {
			this.root.preOrder();
		}
	}
	public void infixOrder() {
		
		if(this.root==null) {
			System.out.println("二叉树为空，无法遍历");
		}else {
			this.root.infixOrder();
		}
	}
	public void postOrder() {
		
		if(this.root==null) {
			System.out.println("二叉树为空，无法遍历");
		}else {
			this.root.postOrder();
		}
	}
	
	public void preSearch(int no) {
		
		if(this.root==null) {
			System.out.println("二叉树为空，无法查找");
			return;
		}else {
			HeroNode node=this.root.preSearch(no);
			if(node!=null) {
				System.out.println(node);
			}else {
				System.out.println("找不到编号为["+no+"]的数据~");
			}
		}
	}
	
	public void infixSearch(int no) {
		
		if(this.root==null) {
			System.out.println("二叉树为空，无法查找");
			return;
		}else {
			HeroNode node=this.root.infixSearch(no);
			if(node!=null) {
				System.out.println(node);
			}else {
				System.out.println("找不到编号为["+no+"]的数据~");
			}
		}
	}
	
	public void postSearch(int no) {
		
		if(this.root==null) {
			System.out.println("二叉树为空，无法查找");
			return;
		}else {
			HeroNode node=this.root.postSearch(no);
			if(node!=null) {
				System.out.println(node);
			}else {
				System.out.println("找不到编号为["+no+"]的数据~");
			}
		}
	}
	
	private class HeroNode{
		
		private int no;
		private String name;
		private HeroNode left;
		private HeroNode right;
		
		public HeroNode(int no, String name) {

			this.no = no;
			this.name = name;
		}
		
		/**
		 * 	递归删除节点的数据
		 * 	假定删除的是叶子节点，直接删除
		 * 	假定删除的不是叶子节点，删除整颗子树
		 * 	删除当前节点，首先找到前一个节点的左、右节点
		 * @param no
		 */
		public void delNode(int no) {
			
			if(this.left!=null && this.left.no==no) {
				this.left=null;//置为空，表示删除
				return; //递归结束
			}
			if(this.right!=null && this.right.no==no) {
				this.right=null;  //删除
				return;
			}
			if(this.left!=null) { //左右节点都无法删除，左递归
				this.left.delNode(no);//不需要返回
			}
			if(this.right!=null) {
				this.right.delNode(no);
			}
		}

		/**
		 * 	递归删除节点的数据
		 * 	假定删除的是叶子节点，直接删除
		 * 	假定删除的不是叶子节点，将其左子节点接上
		 * 	删除当前节点，首先找到前一个节点的左、右节点
		 * @param no
		 */
		/*public void delNodeAndAddLeftNode(int no) {
			
			if(this.left!=null && this.left.no==no) {
				this.left=null;//置为空，表示删除
				return; //递归结束
			}
			if(this.right!=null && this.right.no==no) {
				this.right=null;  //删除
				return;
			}
			if(this.left!=null) { //左右节点都无法删除，左递归
				this.left.delNode(no);//不需要返回
			}
			if(this.right!=null) {
				this.right.delNode(no);
			}
			
		}
		*/
		public void preOrder() {
			
			System.out.println(this);
			if(this.left!=null) {
				this.left.preOrder();
			}
			if(this.right!=null) {
				this.right.preOrder();
			}
		}
		
		public void infixOrder() {
			
			if(this.left!=null) {
				this.left.infixOrder();
			}
			System.out.println(this);
			if(this.right!=null) {
				this.right.infixOrder();
			}
		}
		
		public void postOrder() {
			
			if(this.left!=null) {
				this.left.preOrder();
			}
			if(this.right!=null) {
				this.right.preOrder();
			}
			System.out.println(this);
		}
		
		/**
		 * 	使用二叉树进行递归的前中后查找
		 * @param no id
		 * @return 返回当前查找的数据的信息
		 */
		public HeroNode preSearch(int no) {

			System.out.println("前序遍历查找递归~~~");
			HeroNode node=null; //保存返回的节点
			if(this.no==no) { //如果找到，直接返回
				return this;
			}
			//找不到，向左递归
			if(this.left!=null) { //需要判断左子节点是否为空
				node = this.left.preSearch(no);
			}
			if(node!=null) {
				return node;
			}
			if(this.right!=null) {
				node=left.preSearch(no);
			}
			return node; //不需要判断node是否非空，直接返回
		}
		
		/**
		 * 	中序遍历查找
		 * @param no
		 * @return
		 */
		public HeroNode infixSearch(int no) {
			
			HeroNode node=null; //保存返回的节点
			//找不到，向左递归
			if(this.left!=null) { //需要判断左子节点是否为空
				node = this.left.infixSearch(no);
			}
			if(node!=null) {
				return node;
			}
			System.out.println("中序遍历查找递归~~~");
			if(this.no==no) { //如果找到，直接返回
				return this;
			}
			if(this.right!=null) {
				node=this.right.infixSearch(no);
			}
			return node; //不需要判断node是否非空，直接返回
		}
		/**
		 * 	后序遍历查找
		 * @param no
		 * @return
		 */
		public HeroNode postSearch(int no) {
			
			HeroNode node=null; //保存返回的节点
			//找不到，向左递归
			if(this.left!=null) { //需要判断左子节点是否为空
				node = this.left.postSearch(no);
			}
			if(node!=null) {
				return node;
			}
			if(this.right!=null) {
				node=this.right.postSearch(no);
			}
			if(node!=null) {
				return node;
			}
			System.out.println("后序遍历查找递归~~~");
			if(this.no==no) { //如果找到，直接返回
				return this;
			}
			return node; //不需要判断node是否非空，直接返回
		}
		
		@Override
		public String toString() {
			return "HeroNode [no=" + no + ", name=" + name + "]";
		}
	}
}
