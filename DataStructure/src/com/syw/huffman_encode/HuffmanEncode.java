package com.syw.huffman_encode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	使用哈夫曼树生成哈夫曼编码
 * @author Administrator
 *
 */
public class HuffmanEncode {

	private static Node root;
	
	private static Map<Byte,String> huffmanCode=new HashMap<>();//保存哈夫曼编码
	private static StringBuilder codeBuilder=new StringBuilder();//保存某个节点的编码
	
	public void huffmanTree(byte[] array) {
		
		root = createHuffmanTree(array);
		System.out.println("根节点信息："+root);
	}
	
	/**
	 * 	打印哈夫曼树
	 * @param array
	 */
	public void print(byte[] array) {
		
		if(root==null) {
			System.out.println("哈夫曼树为空，无法遍历...");
			return;
		}
		root.preOrder();
	}
	
	/**
	 * 	获取每个字符的哈夫曼编码
	 * @return
	 */
	public static Map<Byte,String> getHuffmanCode() {
		
		if(root!=null) {
			//根节点无编码传递-->""
			getHuffmanCode(root,"",codeBuilder);
		}
		return huffmanCode;
	}
	
	/**
	 * 	获取哈夫曼编码
	 * @param node 传入的节点
	 * @param code 编码，左：0 右：1
	 * @param builder 返回的哈夫曼编码
	 */
	private static void getHuffmanCode(Node node,String code,StringBuilder builder) {
		
		//将编码加入到StringBuilder 2 中--->每次递归都创建一个新的builder保存当前递归的编码
		//非叶子节点都要将当前路径的左：0 	右：1 加入到builder中
		StringBuilder stringBuilder=new StringBuilder(builder);
		stringBuilder.append(code);
		if(node!=null) { // 不处理空节点
			if(node.data==null) { //data为空，表明该节点非叶子结点
				//左递归
				getHuffmanCode(node.left,"0",stringBuilder);
				//右递归
				getHuffmanCode(node.right,"1",stringBuilder);
			}else { //找到了最外的叶子结点，将编码加入到map中
				huffmanCode.put(node.data, stringBuilder.toString());
			}
		}
	}
	
	/**
	 * @param bytes 待压缩的byte数组
	 * @return 返回一个经过哈夫曼编码后的字节数组
	 */
	public byte[] huffmanZip(byte[] bytes) {
		
		root=createHuffmanTree(bytes);//构建哈夫曼树
		//获取哈夫曼 编码
		getHuffmanCode(root,"",codeBuilder);
		byte[] huffmanBytes=zip(bytes);
		return huffmanBytes;
	}
	
	/**
	 *  使用哈夫曼编码来进行文件的压缩
	 * @param src 待压缩文件的路径
	 * @param dest 压缩之后输出的路径
	 * @return
	 * @throws Exception 
	 */
	public void zipFile(String src,String dest) throws Exception {
		
		//1、首先读取文件的内容
		InputStream is=new FileInputStream(src);
		OutputStream os=new FileOutputStream(dest);
		ObjectOutputStream oos=new ObjectOutputStream(os);
		//从文件读数据
		byte[] readFromFile=new byte[is.available()];
		//将文件读到字节数组中
		is.read(readFromFile);
		//2、获取压缩后的哈夫曼字节数组
		byte[] huffmanByte = huffmanZip(readFromFile);
		//3、将压缩后的哈夫曼字节数组和哈夫曼编码表写入文件
		oos.writeObject(huffmanByte);
		oos.writeObject(huffmanCode);
		System.out.println("压缩文件成功...");
		is.close();
		os.close();
		oos.close();
	}
	
	/**
	 * @param zipFile 准备解压的压缩文件
	 * @param dest 解压到的路径
	 * @throws Exception
	 */
	public void unZipFile(String zipFile,String dest) throws Exception {
		
		//1、首先读取文件的内容
		InputStream is=new FileInputStream(zipFile);
		OutputStream os=new FileOutputStream(dest);
		ObjectInputStream ois=new ObjectInputStream(is);
		byte[] huffmanByte = (byte[]) ois.readObject();
		@SuppressWarnings("unchecked")
		Map<Byte,String> huffmanCode = (Map<Byte, String>) ois.readObject();
		byte[] decode = decode(huffmanCode,huffmanByte);
		os.write(decode);
		System.out.println("解压成功...");
		is.close();
		ois.close();
		os.close();
	}
	
	/*
	 * 	将byte array转为压缩后的字节数组
	 * @param src
	 * @return
	 */
	public static byte[] zip(byte[] src) {
		
		byte[] huffmanByteCode; //用于保存最终返回的哈夫曼编码字节数组
		//1、读取src字节数组的原始数据，并且从哈夫曼编码表(huffmanCode)获取对应的编码加入到StringBuilder
		StringBuilder builder=new StringBuilder();
		for(byte key : src) {
			builder.append(huffmanCode.get(key));
		}
		System.out.println(builder+"len="+builder.length());
		//2、计算 byte[]数组的长度
		int len=-1;
		if(builder.length()%8==0) {
			len=builder.length()/8;
		}else {
			len=builder.length()/8+1; // 整型除法会舍弃小数位
		}
		//创建哈夫曼编码后的byte[]数组
		huffmanByteCode=new byte[len];
		String str="";
		int index=0; // byte[]数组的小标
		//3、将builder转换成为byte[]
		for(int i=0;i<builder.length();i+=8) { //8位数一个字节
			
			if(i+8 > builder.length()) { // i 每一次加8，到最后一次不一定是8的倍数
				str=builder.substring(i); //截取字符串 从  i 到 末尾
			}else {
				str=builder.substring(i, i+8); //加 8 是因为substring [X,Y) 左开右闭区间
			}
			huffmanByteCode[index++]=(byte) Integer.parseInt(str, 2); //转换为二进制
		}
		return huffmanByteCode;
	}
	
	
	
	public static byte[] decode(byte[] huffmanByteArray) {
		
		return decode(huffmanCode,huffmanByteArray);
	}
	
	/**
	 * 	解码
	 * @param huffmanEncodeMap 哈夫曼编码表
	 * @param huffmanByteArray 编码后的哈夫曼byte数组
	 * @return
	 */
	private static byte[] decode(Map<Byte,String> huffmanEncodeMap,byte[] huffmanByteArray) {
	
		StringBuilder builder=new StringBuilder();
		boolean flag=true;//是否需要高位补位数，最后一个字节不需要补充位数
		//1、将编码后的byte数组转化为二进制的字符串，使用StringBuilder拼接
		for(int i=0;i<huffmanByteArray.length;i++) {
			if(i==huffmanByteArray.length-1) { //i到达byte数组最后一位
				builder.append(byteToBinaryString(!flag, huffmanByteArray[i]));
			}else {
				builder.append(byteToBinaryString(flag, huffmanByteArray[i]));
			}
		}
		//2、获取哈夫曼编码的解码表使用编码表反转
		Map<String,Byte> decodeTable=new HashMap<>();
		for(Map.Entry<Byte, String> entry : huffmanEncodeMap.entrySet()) {
			//加入到解码表中
			decodeTable.put(entry.getValue(), entry.getKey());
		}
		//创建一个ArrayList，存放解码后到达字节数组数据
		List<Byte> list=new ArrayList<>();
		//3、字符串匹配，将二进制字符串匹配到的数据加入List中
		for(int i=0;i<builder.length();) {
			int count=1; //移动指针，扫码字符串
			Byte b=null; //用于存储截取的二进制字符串
			flag=true;//flag 用于结束当前字符串匹配扫描
			while(flag) {
				
				String key=builder.substring(i, i+count);//获取key
				b=decodeTable.get(key); //每次从解码表中扫描匹配
				if(b==null) {
					count++;
				}else {
					flag=false;
				}
			}
			list.add(b);//添加到list中
			i=i+count;//i移动到count的位置匹配
		}
		byte[] afterDecodeByte=new byte[list.size()];
		for(int i=0;i<list.size();i++) {
			afterDecodeByte[i]=list.get(i);
		}
		return afterDecodeByte ;
	}
	
	/**
	 * !!! 如果最后一个字节也补到8位，解码后与原始byte[]的数据就会不一致
	 * @param flag 是否需要高位补充位数 ,ture需要，false不需要：最后一个字节不用补高位[ ---> 该转换的 byte 是一个整数]
	 * @param data 需要转换为二进制String类型的byte数据
	 * @return 返回一个转换为二进制字符串的数据
	 */
	private static String byteToBinaryString(boolean flag,byte data) {
		
		String bitStr="";
		//运算返回的是 32 位整型数据的二进制数，将data转换为 int型数据
		int temp=data; 
		if(flag) {
			// 由于整数返回的补码不到8位，需要 和 1 0000 0000  进行 '或' 运算
			temp = (temp | 256);
		}
		bitStr=Integer.toBinaryString(temp);
		if(flag) {
			return bitStr.substring(bitStr.length()-8); //返回后8位
		}else {
			return bitStr; //最后一个字节不用补高位
		}
	}
	
	/**
	 * 	创建哈夫曼树
	 * @param array
	 * @return
	 */
	private Node createHuffmanTree(byte[] array) {
		
		List<Node> nodes=getDataList(array);
		while(nodes.size() > 1) {

			Collections.sort(nodes);
			Node leftNode=nodes.get(0);//左节点
			Node rightNode=nodes.get(1);//右节点
			//父节点并无数据信息，只有权值
			Node parentNode=new Node(null,leftNode.weight+rightNode.weight);
			//父节点指向左右节点
			parentNode.left=leftNode;
			parentNode.right=rightNode;
			//将当前构建哈夫曼树的左右子节点从集合中移除
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//父节点加入到集合中继续构建哈夫曼树
			nodes.add(parentNode);
		}
		return nodes.get(0);
	}
	
	/**
	 * 将array  --->  toList
	 * @param array 待转换为ArrayList的数组
	 * @return 返回一个 Node 的List-->统计好每一个字符出现的次数
	 */
	private List<Node> getDataList(byte[] array) {
		
		//返回的List
		List<Node> nodes=new ArrayList<>();
		//使用Map来辅助统计字符
		Map<Byte,Integer> map=new HashMap<>();
		for(byte data:array) {
			Integer count=map.get(data); //从map中获取对应 key出现的次数
			if(count==null) { //map无此数据，加入map
				map.put(data, 1);
			}else {
				map.put(data, count+1);
			}
		}
		// map中已经存储了每一个字符出现的次数
		/*将map的数据加入到list并范湖*/
		for(Map.Entry<Byte, Integer> entry:map.entrySet()) {
			//创建Node对象，并加入到list中
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}

	private class Node implements Comparable<Node>{
		
		Byte data; //用于保存编码的数据 --> 'a'=97
		int weight; //权值
		Node left;
		Node right;
		
		public Node(Byte data, int weight) {

			this.data = data;
			this.weight = weight;
		}
		
		public void preOrder() {
			
			if(this!=null) {
				System.out.println(this);
			}
			if(this.left!=null) {
				this.left.preOrder();
			}
			if(this.right!=null) {
				this.right.preOrder();
			}
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			
			/*能够使用集合的排序功能(从小到大)，前面加负号从大到小*/
			return this.weight-o.weight;
		}
	}
}
