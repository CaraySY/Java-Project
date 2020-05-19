package com.syw;

import java.util.Scanner;

import org.junit.Test;

import com.syw.hashtable.Hashtable;

/**
 * 	���ڲ���Hashtable
 * @author Administrator
 *
 */
public class HashtableTest {

	private Scanner keyboard=new Scanner(System.in);
	
	@Test
	public void fun1() {
		
		Hashtable table=new Hashtable(7);
		int no=-1;
		for(int i=0;i<10;i++) {
			
			table.add(i,"��"+i+"��");
		}
		String key="";//�˵�����
		boolean loop=true;//�����Ƿ��˳��˵�
		while(loop) {
			System.out.println("***************Welcome Hashtable Test Programmer******************");
			System.out.println("\t\t\tshow:��ʾHashtable����������");
			System.out.println("\t\t\texit:�˳�����");
			System.out.println("\t\t\tfind:��ѯԱ����Ϣ");
			System.out.println("\t\t\tadd:������ݵ�Hashtable");
			System.out.println("\t\t\tremove:��Hashtable�Ƴ�����");
			System.out.println("\t\t\t������ѡ��:");
			key=keyboard.next();
			switch(key) {
			case "show":
				table.list();
				break;
			case "exit":
				loop=false;
				System.exit(0);
			case "find":
				System.out.println("�����뵽��ѯ��Ա����ID��");
				no=keyboard.nextInt();
				table.find(no);
				break;
			case "add":
				System.out.println("������ID��");
				no=keyboard.nextInt();
				System.out.println("������������");
				String name=keyboard.next();
				table.add(no,name);
				break;
			case "remove":
				System.out.println("��������Ҫɾ����Ա����ID��");
				no=keyboard.nextInt();
				table.remove(no);
				break;
			default: 
				break;
			}
		}
		table.list();
	}
}
