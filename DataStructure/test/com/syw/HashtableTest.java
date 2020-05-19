package com.syw;

import java.util.Scanner;

import org.junit.Test;

import com.syw.hashtable.Hashtable;

/**
 * 	用于测试Hashtable
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
			
			table.add(i,"张"+i+"丰");
		}
		String key="";//菜单输入
		boolean loop=true;//控制是否退出菜单
		while(loop) {
			System.out.println("***************Welcome Hashtable Test Programmer******************");
			System.out.println("\t\t\tshow:显示Hashtable的所有数据");
			System.out.println("\t\t\texit:退出程序");
			System.out.println("\t\t\tfind:查询员工信息");
			System.out.println("\t\t\tadd:添加数据到Hashtable");
			System.out.println("\t\t\tremove:从Hashtable移除数据");
			System.out.println("\t\t\t请输入选择:");
			key=keyboard.next();
			switch(key) {
			case "show":
				table.list();
				break;
			case "exit":
				loop=false;
				System.exit(0);
			case "find":
				System.out.println("请输入到查询的员工的ID：");
				no=keyboard.nextInt();
				table.find(no);
				break;
			case "add":
				System.out.println("请输入ID：");
				no=keyboard.nextInt();
				System.out.println("请输入姓名：");
				String name=keyboard.next();
				table.add(no,name);
				break;
			case "remove":
				System.out.println("请输入需要删除的员工的ID：");
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
