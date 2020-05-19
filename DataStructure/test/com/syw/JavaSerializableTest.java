package com.syw;

import java.io.File;

import org.junit.Test;

import com.syw.bean.Person;
import com.syw.bean.Teacher;
import com.syw.common.SerializableUtils;

public class JavaSerializableTest {

	@Test
	public void fun1() {
		
		Person person=new Person();
		person.setName("张三");
		person.setAge(25);
		Teacher teacher=new Teacher();
		teacher.setPerson(person);
		teacher.setName("李老师");
		File file=new File("data.txt");
		//SerializableUtils.writeObject(person, file);
		SerializableUtils.writeObject(teacher, file);
		/*反序列化不会调用构造方法*/
		Teacher readObject = (Teacher) SerializableUtils.readObject(file);
		System.out.println(readObject);
	}
	
	/*从文件反序列化到内存中*/
	@Test
	public void fun2() {
		
		/*稀疏数组反序列化*/
		System.out.println("Reverse Serializable Array...");
		int[][] newSparseArray  = (int[][]) SerializableUtils.readObject(new File("sparse.data"));
		/*稀疏数组转为原始数组*/
		int row=newSparseArray[0][0];
		int col=newSparseArray[0][1];
		int k,z;
		int temp;
		int[][] orignalArray=new int[row][col];
		for(int i=1;i<newSparseArray.length;i++) { // i 控制行  列写死就可以，从第一行开始
				k=newSparseArray[i][0];
				z=newSparseArray[i][1];
				temp=newSparseArray[i][2];//value
				orignalArray[k][z]=temp;
		}
		for(int[] ro:orignalArray) {
			for(int data:ro) {
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}
}
