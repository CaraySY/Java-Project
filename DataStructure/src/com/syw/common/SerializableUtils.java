package com.syw.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 	���л�����
 * @author Administrator
 *
 */
public class SerializableUtils {

	public static void writeObject(Object object,File file) {
		
		/*ʹ��try������ţ�������try�������Զ��ر���Դ*/
		/*ObjectOutputStream ����ʵ�ֶ�������л�*/
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file))) {
			
			oos.writeObject(object);//д���ļ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object readObject(File file) {
		
		Object obj=null;
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file))) {
		    obj = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
