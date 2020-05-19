package com.syw.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 	序列化工具
 * @author Administrator
 *
 */
public class SerializableUtils {

	public static void writeObject(Object object,File file) {
		
		/*使用try块的括号，可以在try语句结束自动关闭资源*/
		/*ObjectOutputStream 用来实现对象的序列化*/
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file))) {
			
			oos.writeObject(object);//写入文件中
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
