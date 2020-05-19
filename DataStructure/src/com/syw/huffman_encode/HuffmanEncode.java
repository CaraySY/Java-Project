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
 * 	ʹ�ù����������ɹ���������
 * @author Administrator
 *
 */
public class HuffmanEncode {

	private static Node root;
	
	private static Map<Byte,String> huffmanCode=new HashMap<>();//�������������
	private static StringBuilder codeBuilder=new StringBuilder();//����ĳ���ڵ�ı���
	
	public void huffmanTree(byte[] array) {
		
		root = createHuffmanTree(array);
		System.out.println("���ڵ���Ϣ��"+root);
	}
	
	/**
	 * 	��ӡ��������
	 * @param array
	 */
	public void print(byte[] array) {
		
		if(root==null) {
			System.out.println("��������Ϊ�գ��޷�����...");
			return;
		}
		root.preOrder();
	}
	
	/**
	 * 	��ȡÿ���ַ��Ĺ���������
	 * @return
	 */
	public static Map<Byte,String> getHuffmanCode() {
		
		if(root!=null) {
			//���ڵ��ޱ��봫��-->""
			getHuffmanCode(root,"",codeBuilder);
		}
		return huffmanCode;
	}
	
	/**
	 * 	��ȡ����������
	 * @param node ����Ľڵ�
	 * @param code ���룬��0 �ң�1
	 * @param builder ���صĹ���������
	 */
	private static void getHuffmanCode(Node node,String code,StringBuilder builder) {
		
		//��������뵽StringBuilder 2 ��--->ÿ�εݹ鶼����һ���µ�builder���浱ǰ�ݹ�ı���
		//��Ҷ�ӽڵ㶼Ҫ����ǰ·������0 	�ң�1 ���뵽builder��
		StringBuilder stringBuilder=new StringBuilder(builder);
		stringBuilder.append(code);
		if(node!=null) { // ������սڵ�
			if(node.data==null) { //dataΪ�գ������ýڵ��Ҷ�ӽ��
				//��ݹ�
				getHuffmanCode(node.left,"0",stringBuilder);
				//�ҵݹ�
				getHuffmanCode(node.right,"1",stringBuilder);
			}else { //�ҵ��������Ҷ�ӽ�㣬��������뵽map��
				huffmanCode.put(node.data, stringBuilder.toString());
			}
		}
	}
	
	/**
	 * @param bytes ��ѹ����byte����
	 * @return ����һ�������������������ֽ�����
	 */
	public byte[] huffmanZip(byte[] bytes) {
		
		root=createHuffmanTree(bytes);//������������
		//��ȡ������ ����
		getHuffmanCode(root,"",codeBuilder);
		byte[] huffmanBytes=zip(bytes);
		return huffmanBytes;
	}
	
	/**
	 *  ʹ�ù����������������ļ���ѹ��
	 * @param src ��ѹ���ļ���·��
	 * @param dest ѹ��֮�������·��
	 * @return
	 * @throws Exception 
	 */
	public void zipFile(String src,String dest) throws Exception {
		
		//1�����ȶ�ȡ�ļ�������
		InputStream is=new FileInputStream(src);
		OutputStream os=new FileOutputStream(dest);
		ObjectOutputStream oos=new ObjectOutputStream(os);
		//���ļ�������
		byte[] readFromFile=new byte[is.available()];
		//���ļ������ֽ�������
		is.read(readFromFile);
		//2����ȡѹ����Ĺ������ֽ�����
		byte[] huffmanByte = huffmanZip(readFromFile);
		//3����ѹ����Ĺ������ֽ�����͹����������д���ļ�
		oos.writeObject(huffmanByte);
		oos.writeObject(huffmanCode);
		System.out.println("ѹ���ļ��ɹ�...");
		is.close();
		os.close();
		oos.close();
	}
	
	/**
	 * @param zipFile ׼����ѹ��ѹ���ļ�
	 * @param dest ��ѹ����·��
	 * @throws Exception
	 */
	public void unZipFile(String zipFile,String dest) throws Exception {
		
		//1�����ȶ�ȡ�ļ�������
		InputStream is=new FileInputStream(zipFile);
		OutputStream os=new FileOutputStream(dest);
		ObjectInputStream ois=new ObjectInputStream(is);
		byte[] huffmanByte = (byte[]) ois.readObject();
		@SuppressWarnings("unchecked")
		Map<Byte,String> huffmanCode = (Map<Byte, String>) ois.readObject();
		byte[] decode = decode(huffmanCode,huffmanByte);
		os.write(decode);
		System.out.println("��ѹ�ɹ�...");
		is.close();
		ois.close();
		os.close();
	}
	
	/*
	 * 	��byte arrayתΪѹ������ֽ�����
	 * @param src
	 * @return
	 */
	public static byte[] zip(byte[] src) {
		
		byte[] huffmanByteCode; //���ڱ������շ��صĹ����������ֽ�����
		//1����ȡsrc�ֽ������ԭʼ���ݣ����Ҵӹ����������(huffmanCode)��ȡ��Ӧ�ı�����뵽StringBuilder
		StringBuilder builder=new StringBuilder();
		for(byte key : src) {
			builder.append(huffmanCode.get(key));
		}
		System.out.println(builder+"len="+builder.length());
		//2������ byte[]����ĳ���
		int len=-1;
		if(builder.length()%8==0) {
			len=builder.length()/8;
		}else {
			len=builder.length()/8+1; // ���ͳ���������С��λ
		}
		//����������������byte[]����
		huffmanByteCode=new byte[len];
		String str="";
		int index=0; // byte[]�����С��
		//3����builderת����Ϊbyte[]
		for(int i=0;i<builder.length();i+=8) { //8λ��һ���ֽ�
			
			if(i+8 > builder.length()) { // i ÿһ�μ�8�������һ�β�һ����8�ı���
				str=builder.substring(i); //��ȡ�ַ��� ��  i �� ĩβ
			}else {
				str=builder.substring(i, i+8); //�� 8 ����Ϊsubstring [X,Y) ���ұ�����
			}
			huffmanByteCode[index++]=(byte) Integer.parseInt(str, 2); //ת��Ϊ������
		}
		return huffmanByteCode;
	}
	
	
	
	public static byte[] decode(byte[] huffmanByteArray) {
		
		return decode(huffmanCode,huffmanByteArray);
	}
	
	/**
	 * 	����
	 * @param huffmanEncodeMap �����������
	 * @param huffmanByteArray �����Ĺ�����byte����
	 * @return
	 */
	private static byte[] decode(Map<Byte,String> huffmanEncodeMap,byte[] huffmanByteArray) {
	
		StringBuilder builder=new StringBuilder();
		boolean flag=true;//�Ƿ���Ҫ��λ��λ�������һ���ֽڲ���Ҫ����λ��
		//1����������byte����ת��Ϊ�����Ƶ��ַ�����ʹ��StringBuilderƴ��
		for(int i=0;i<huffmanByteArray.length;i++) {
			if(i==huffmanByteArray.length-1) { //i����byte�������һλ
				builder.append(byteToBinaryString(!flag, huffmanByteArray[i]));
			}else {
				builder.append(byteToBinaryString(flag, huffmanByteArray[i]));
			}
		}
		//2����ȡ����������Ľ����ʹ�ñ����ת
		Map<String,Byte> decodeTable=new HashMap<>();
		for(Map.Entry<Byte, String> entry : huffmanEncodeMap.entrySet()) {
			//���뵽�������
			decodeTable.put(entry.getValue(), entry.getKey());
		}
		//����һ��ArrayList����Ž���󵽴��ֽ���������
		List<Byte> list=new ArrayList<>();
		//3���ַ���ƥ�䣬���������ַ���ƥ�䵽�����ݼ���List��
		for(int i=0;i<builder.length();) {
			int count=1; //�ƶ�ָ�룬ɨ���ַ���
			Byte b=null; //���ڴ洢��ȡ�Ķ������ַ���
			flag=true;//flag ���ڽ�����ǰ�ַ���ƥ��ɨ��
			while(flag) {
				
				String key=builder.substring(i, i+count);//��ȡkey
				b=decodeTable.get(key); //ÿ�δӽ������ɨ��ƥ��
				if(b==null) {
					count++;
				}else {
					flag=false;
				}
			}
			list.add(b);//��ӵ�list��
			i=i+count;//i�ƶ���count��λ��ƥ��
		}
		byte[] afterDecodeByte=new byte[list.size()];
		for(int i=0;i<list.size();i++) {
			afterDecodeByte[i]=list.get(i);
		}
		return afterDecodeByte ;
	}
	
	/**
	 * !!! ������һ���ֽ�Ҳ����8λ���������ԭʼbyte[]�����ݾͻ᲻һ��
	 * @param flag �Ƿ���Ҫ��λ����λ�� ,ture��Ҫ��false����Ҫ�����һ���ֽڲ��ò���λ[ ---> ��ת���� byte ��һ������]
	 * @param data ��Ҫת��Ϊ������String���͵�byte����
	 * @return ����һ��ת��Ϊ�������ַ���������
	 */
	private static String byteToBinaryString(boolean flag,byte data) {
		
		String bitStr="";
		//���㷵�ص��� 32 λ�������ݵĶ�����������dataת��Ϊ int������
		int temp=data; 
		if(flag) {
			// �����������صĲ��벻��8λ����Ҫ �� 1 0000 0000  ���� '��' ����
			temp = (temp | 256);
		}
		bitStr=Integer.toBinaryString(temp);
		if(flag) {
			return bitStr.substring(bitStr.length()-8); //���غ�8λ
		}else {
			return bitStr; //���һ���ֽڲ��ò���λ
		}
	}
	
	/**
	 * 	������������
	 * @param array
	 * @return
	 */
	private Node createHuffmanTree(byte[] array) {
		
		List<Node> nodes=getDataList(array);
		while(nodes.size() > 1) {

			Collections.sort(nodes);
			Node leftNode=nodes.get(0);//��ڵ�
			Node rightNode=nodes.get(1);//�ҽڵ�
			//���ڵ㲢��������Ϣ��ֻ��Ȩֵ
			Node parentNode=new Node(null,leftNode.weight+rightNode.weight);
			//���ڵ�ָ�����ҽڵ�
			parentNode.left=leftNode;
			parentNode.right=rightNode;
			//����ǰ�������������������ӽڵ�Ӽ������Ƴ�
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//���ڵ���뵽�����м���������������
			nodes.add(parentNode);
		}
		return nodes.get(0);
	}
	
	/**
	 * ��array  --->  toList
	 * @param array ��ת��ΪArrayList������
	 * @return ����һ�� Node ��List-->ͳ�ƺ�ÿһ���ַ����ֵĴ���
	 */
	private List<Node> getDataList(byte[] array) {
		
		//���ص�List
		List<Node> nodes=new ArrayList<>();
		//ʹ��Map������ͳ���ַ�
		Map<Byte,Integer> map=new HashMap<>();
		for(byte data:array) {
			Integer count=map.get(data); //��map�л�ȡ��Ӧ key���ֵĴ���
			if(count==null) { //map�޴����ݣ�����map
				map.put(data, 1);
			}else {
				map.put(data, count+1);
			}
		}
		// map���Ѿ��洢��ÿһ���ַ����ֵĴ���
		/*��map�����ݼ��뵽list������*/
		for(Map.Entry<Byte, Integer> entry:map.entrySet()) {
			//����Node���󣬲����뵽list��
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}

	private class Node implements Comparable<Node>{
		
		Byte data; //���ڱ����������� --> 'a'=97
		int weight; //Ȩֵ
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
			
			/*�ܹ�ʹ�ü��ϵ�������(��С����)��ǰ��Ӹ��ŴӴ�С*/
			return this.weight-o.weight;
		}
	}
}
