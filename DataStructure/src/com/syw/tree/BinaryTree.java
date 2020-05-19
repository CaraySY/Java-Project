package com.syw.tree;

public class BinaryTree {

	private HeroNode root;
	
	public BinaryTree() {
		
	}
	
	public void init() {
		//�ֶ�����������
		HeroNode node1=new HeroNode(1,"�ν�");
		HeroNode node2=new HeroNode(2,"����");
		HeroNode node3=new HeroNode(3,"¬����");
		HeroNode node4=new HeroNode(4,"�ֳ�");
		HeroNode node5=new HeroNode(5,"��ʤ");
		root=node1;
		node1.left=node2;
		node1.right=node3;
		node3.right=node4;
		node3.left=node5;
	}
	
	public void delNode(int no) {
		
		if(this.root==null) {
			System.out.println("������Ϊ�գ��޷�ɾ��");
		}else {
			if(this.root.no==no) {
				this.root=null; //ɾ���Ľڵ��Ǹ��ڵ㣬�����Ŷ�����ɾ��
			}
			this.root.delNode(no);
		}
	}
	
	
	
	public void preOrder() {
		
		if(this.root==null) {
			System.out.println("������Ϊ�գ��޷�����");
		}else {
			this.root.preOrder();
		}
	}
	public void infixOrder() {
		
		if(this.root==null) {
			System.out.println("������Ϊ�գ��޷�����");
		}else {
			this.root.infixOrder();
		}
	}
	public void postOrder() {
		
		if(this.root==null) {
			System.out.println("������Ϊ�գ��޷�����");
		}else {
			this.root.postOrder();
		}
	}
	
	public void preSearch(int no) {
		
		if(this.root==null) {
			System.out.println("������Ϊ�գ��޷�����");
			return;
		}else {
			HeroNode node=this.root.preSearch(no);
			if(node!=null) {
				System.out.println(node);
			}else {
				System.out.println("�Ҳ������Ϊ["+no+"]������~");
			}
		}
	}
	
	public void infixSearch(int no) {
		
		if(this.root==null) {
			System.out.println("������Ϊ�գ��޷�����");
			return;
		}else {
			HeroNode node=this.root.infixSearch(no);
			if(node!=null) {
				System.out.println(node);
			}else {
				System.out.println("�Ҳ������Ϊ["+no+"]������~");
			}
		}
	}
	
	public void postSearch(int no) {
		
		if(this.root==null) {
			System.out.println("������Ϊ�գ��޷�����");
			return;
		}else {
			HeroNode node=this.root.postSearch(no);
			if(node!=null) {
				System.out.println(node);
			}else {
				System.out.println("�Ҳ������Ϊ["+no+"]������~");
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
		 * 	�ݹ�ɾ���ڵ������
		 * 	�ٶ�ɾ������Ҷ�ӽڵ㣬ֱ��ɾ��
		 * 	�ٶ�ɾ���Ĳ���Ҷ�ӽڵ㣬ɾ����������
		 * 	ɾ����ǰ�ڵ㣬�����ҵ�ǰһ���ڵ�����ҽڵ�
		 * @param no
		 */
		public void delNode(int no) {
			
			if(this.left!=null && this.left.no==no) {
				this.left=null;//��Ϊ�գ���ʾɾ��
				return; //�ݹ����
			}
			if(this.right!=null && this.right.no==no) {
				this.right=null;  //ɾ��
				return;
			}
			if(this.left!=null) { //���ҽڵ㶼�޷�ɾ������ݹ�
				this.left.delNode(no);//����Ҫ����
			}
			if(this.right!=null) {
				this.right.delNode(no);
			}
		}

		/**
		 * 	�ݹ�ɾ���ڵ������
		 * 	�ٶ�ɾ������Ҷ�ӽڵ㣬ֱ��ɾ��
		 * 	�ٶ�ɾ���Ĳ���Ҷ�ӽڵ㣬�������ӽڵ����
		 * 	ɾ����ǰ�ڵ㣬�����ҵ�ǰһ���ڵ�����ҽڵ�
		 * @param no
		 */
		/*public void delNodeAndAddLeftNode(int no) {
			
			if(this.left!=null && this.left.no==no) {
				this.left=null;//��Ϊ�գ���ʾɾ��
				return; //�ݹ����
			}
			if(this.right!=null && this.right.no==no) {
				this.right=null;  //ɾ��
				return;
			}
			if(this.left!=null) { //���ҽڵ㶼�޷�ɾ������ݹ�
				this.left.delNode(no);//����Ҫ����
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
		 * 	ʹ�ö��������еݹ��ǰ�к����
		 * @param no id
		 * @return ���ص�ǰ���ҵ����ݵ���Ϣ
		 */
		public HeroNode preSearch(int no) {

			System.out.println("ǰ��������ҵݹ�~~~");
			HeroNode node=null; //���淵�صĽڵ�
			if(this.no==no) { //����ҵ���ֱ�ӷ���
				return this;
			}
			//�Ҳ���������ݹ�
			if(this.left!=null) { //��Ҫ�ж����ӽڵ��Ƿ�Ϊ��
				node = this.left.preSearch(no);
			}
			if(node!=null) {
				return node;
			}
			if(this.right!=null) {
				node=left.preSearch(no);
			}
			return node; //����Ҫ�ж�node�Ƿ�ǿգ�ֱ�ӷ���
		}
		
		/**
		 * 	�����������
		 * @param no
		 * @return
		 */
		public HeroNode infixSearch(int no) {
			
			HeroNode node=null; //���淵�صĽڵ�
			//�Ҳ���������ݹ�
			if(this.left!=null) { //��Ҫ�ж����ӽڵ��Ƿ�Ϊ��
				node = this.left.infixSearch(no);
			}
			if(node!=null) {
				return node;
			}
			System.out.println("����������ҵݹ�~~~");
			if(this.no==no) { //����ҵ���ֱ�ӷ���
				return this;
			}
			if(this.right!=null) {
				node=this.right.infixSearch(no);
			}
			return node; //����Ҫ�ж�node�Ƿ�ǿգ�ֱ�ӷ���
		}
		/**
		 * 	�����������
		 * @param no
		 * @return
		 */
		public HeroNode postSearch(int no) {
			
			HeroNode node=null; //���淵�صĽڵ�
			//�Ҳ���������ݹ�
			if(this.left!=null) { //��Ҫ�ж����ӽڵ��Ƿ�Ϊ��
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
			System.out.println("����������ҵݹ�~~~");
			if(this.no==no) { //����ҵ���ֱ�ӷ���
				return this;
			}
			return node; //����Ҫ�ж�node�Ƿ�ǿգ�ֱ�ӷ���
		}
		
		@Override
		public String toString() {
			return "HeroNode [no=" + no + ", name=" + name + "]";
		}
	}
}
