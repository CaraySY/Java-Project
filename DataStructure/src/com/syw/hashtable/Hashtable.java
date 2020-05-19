package com.syw.hashtable;

/**
 * 	使用Hashtable 实现数据缓存
 * @author Administrator
 *
 */
public class Hashtable {

	private EmpLinkedList[] table; //hash数组，保存链表
	
	private int maxSize; //链表的长度
	
	public Hashtable(int maxSize) {
		
		this.maxSize=maxSize;
		table=new EmpLinkedList[maxSize];
		for(int i=0;i<maxSize;i++) {
			table[i]=new EmpLinkedList();//给数组添加默认链表
		}
	}
	
	/**
	 * 	Hashtable的添加
	 * @param emp
	 */
	public void add(int id,String name) {
		
		Emp emp=new Emp(id,name);
		int tableIndex=hash(emp.id);
		table[tableIndex].add(emp);
	}
	
	public void find(int id) {
		
		int tableIndex=hash(id);
		Emp emp = table[tableIndex].find(id);
		if(emp==null) {
			System.out.println("查找不到员工ID为"+id+"的数据信息...");
		}else {
			System.out.println("在第"+(tableIndex+1)+"条链表查找到员工ID为"+id+"的数据信息:"+emp);
		}
	}
	
	public void remove(int id) {
		
		int tableIndex=hash(id);
		Emp emp = table[tableIndex].remove(id);
		if(emp==null) {
			System.out.println("无法删除员工ID为"+id+"的数据信息,Hashtable中无此数据信息...");
		}else {
			System.out.println("在第"+(tableIndex+1)+"条链表删除了该员工ID为"+id+"的数据信息:"+emp);
		}
	}
	
	//遍历
	public void list() {
		
		for(int i=0;i<maxSize;i++) {
			System.out.println("第"+(i+1)+"条链表的数据->");
			table[i].list(i+1);
		}
	}
	
	private int hash(int id) {
		
		return id%maxSize; //求余数法获取数组的下标
	}

	private class EmpLinkedList{
		
		private Emp head; //定义不带头节点的链表，用于保存雇员的信息

		public void add(Emp emp) { //添加雇员到链表中
			
			if(head==null) {
				head=emp;
			}else {
				Emp curNode=head;
				while(true) {
					if(curNode.next==null) {
						break; //找到最后一个节点，退出循环
					}
					curNode=curNode.next;
				}
				curNode.next=emp;
				curNode=emp; //curNode移动一个位置
			}
		}
		
		//查找
		public Emp find(int id) {
			
			Emp curNode=head;
			if(curNode==null) {
				System.out.println("链表为空，要查找的数据不存在...");
				return null;
			}
			while(true) {
				if(curNode.id==id) {
					break;
				}
				if(curNode.next==null) { //遍历链表，找不到该数据
					curNode=null; //将最后一个节点返回并且置为空指针
					break;
				}
				curNode=curNode.next;
			}
			return curNode;
		}
		
		//删除员工数据
		public Emp remove(int id) {
			
			Emp curNode=head;
			Emp node=null;
			Boolean flag=false;
			if(head==null) {
				System.out.println("Hashtable中没有该员工的信息，无法删除...");
				return null;
			}else {
				while(true) {
					if(curNode.next==null) { //该节点为空，直接返回
						break;
					}
					if(curNode.next.id==id) { //找到待删除节点的前一个位置
						flag=true;
						break;
					}
					curNode=curNode.next;
				}
				if(flag) {
					node=curNode.next;
					curNode.next=node.next;
					return node;
				}else {
					return null;
				}
			}
		}
		
		//遍历
		public void list(int listNo) { //遍历整个链表
			
			if(head==null) {
				System.out.println("	->当前第"+listNo+"链表为空!!!");
				return;
			}
			Emp curNode=head;
			while(true) {
				System.out.println("	->Emp infomation:"+curNode);
				if(curNode.next==null) {
					break;
				}
				curNode=curNode.next;
			}
			
		}
	}
	
	private class Emp{ //定义一个雇员实体类
		
		private int id;
		private String name;
		private Emp next; //指向下一个节点
		
		public Emp(int id, String name) {
			
			this.id=id;
			this.name=name;
		}

		@Override
		public String toString() {
			return "Emp [id=" + id + ", name=" + name + "]";
		}
	}
}
