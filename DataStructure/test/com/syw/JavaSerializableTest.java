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
		person.setName("����");
		person.setAge(25);
		Teacher teacher=new Teacher();
		teacher.setPerson(person);
		teacher.setName("����ʦ");
		File file=new File("data.txt");
		//SerializableUtils.writeObject(person, file);
		SerializableUtils.writeObject(teacher, file);
		/*�����л�������ù��췽��*/
		Teacher readObject = (Teacher) SerializableUtils.readObject(file);
		System.out.println(readObject);
	}
	
	/*���ļ������л����ڴ���*/
	@Test
	public void fun2() {
		
		/*ϡ�����鷴���л�*/
		System.out.println("Reverse Serializable Array...");
		int[][] newSparseArray  = (int[][]) SerializableUtils.readObject(new File("sparse.data"));
		/*ϡ������תΪԭʼ����*/
		int row=newSparseArray[0][0];
		int col=newSparseArray[0][1];
		int k,z;
		int temp;
		int[][] orignalArray=new int[row][col];
		for(int i=1;i<newSparseArray.length;i++) { // i ������  ��д���Ϳ��ԣ��ӵ�һ�п�ʼ
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
