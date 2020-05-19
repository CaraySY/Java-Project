package com.syw.hashtable;

/**
 * 	ʹ��Hashtable ʵ�����ݻ���
 * @author Administrator
 *
 */
public class Hashtable {

	private EmpLinkedList[] table; //hash���飬��������
	
	private int maxSize; //����ĳ���
	
	public Hashtable(int maxSize) {
		
		this.maxSize=maxSize;
		table=new EmpLinkedList[maxSize];
		for(int i=0;i<maxSize;i++) {
			table[i]=new EmpLinkedList();//���������Ĭ������
		}
	}
	
	/**
	 * 	Hashtable�����
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
			System.out.println("���Ҳ���Ա��IDΪ"+id+"��������Ϣ...");
		}else {
			System.out.println("�ڵ�"+(tableIndex+1)+"��������ҵ�Ա��IDΪ"+id+"��������Ϣ:"+emp);
		}
	}
	
	public void remove(int id) {
		
		int tableIndex=hash(id);
		Emp emp = table[tableIndex].remove(id);
		if(emp==null) {
			System.out.println("�޷�ɾ��Ա��IDΪ"+id+"��������Ϣ,Hashtable���޴�������Ϣ...");
		}else {
			System.out.println("�ڵ�"+(tableIndex+1)+"������ɾ���˸�Ա��IDΪ"+id+"��������Ϣ:"+emp);
		}
	}
	
	//����
	public void list() {
		
		for(int i=0;i<maxSize;i++) {
			System.out.println("��"+(i+1)+"�����������->");
			table[i].list(i+1);
		}
	}
	
	private int hash(int id) {
		
		return id%maxSize; //����������ȡ������±�
	}

	private class EmpLinkedList{
		
		private Emp head; //���岻��ͷ�ڵ���������ڱ����Ա����Ϣ

		public void add(Emp emp) { //��ӹ�Ա��������
			
			if(head==null) {
				head=emp;
			}else {
				Emp curNode=head;
				while(true) {
					if(curNode.next==null) {
						break; //�ҵ����һ���ڵ㣬�˳�ѭ��
					}
					curNode=curNode.next;
				}
				curNode.next=emp;
				curNode=emp; //curNode�ƶ�һ��λ��
			}
		}
		
		//����
		public Emp find(int id) {
			
			Emp curNode=head;
			if(curNode==null) {
				System.out.println("����Ϊ�գ�Ҫ���ҵ����ݲ�����...");
				return null;
			}
			while(true) {
				if(curNode.id==id) {
					break;
				}
				if(curNode.next==null) { //���������Ҳ���������
					curNode=null; //�����һ���ڵ㷵�ز�����Ϊ��ָ��
					break;
				}
				curNode=curNode.next;
			}
			return curNode;
		}
		
		//ɾ��Ա������
		public Emp remove(int id) {
			
			Emp curNode=head;
			Emp node=null;
			Boolean flag=false;
			if(head==null) {
				System.out.println("Hashtable��û�и�Ա������Ϣ���޷�ɾ��...");
				return null;
			}else {
				while(true) {
					if(curNode.next==null) { //�ýڵ�Ϊ�գ�ֱ�ӷ���
						break;
					}
					if(curNode.next.id==id) { //�ҵ���ɾ���ڵ��ǰһ��λ��
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
		
		//����
		public void list(int listNo) { //������������
			
			if(head==null) {
				System.out.println("	->��ǰ��"+listNo+"����Ϊ��!!!");
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
	
	private class Emp{ //����һ����Աʵ����
		
		private int id;
		private String name;
		private Emp next; //ָ����һ���ڵ�
		
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
