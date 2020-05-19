package com.syw;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;

import com.syw.huffman_encode.HuffmanEncode;
import com.syw.tree.HuffmanTree;

public class HuffmanTreeTest {

	/**
	 * 	�����ͱ�����������
	 */
	@Test
	public void fun1() {
		
		int[] array= {13,7,8,3,29,6,1};
		HuffmanTree tree=new HuffmanTree();
		tree.huffmanTree(array);
		tree.printHuffmanTree(array);
	}
	
	/**
	 * 	����������
	 */
	@Test
	public void fun2() {
		
		//String content="i like like like java do you like a java";
		String content="I am a Chinese, and I love China!!!";
		HuffmanEncode huffmanEncode=new HuffmanEncode();
		byte[] array=content.getBytes();
		huffmanEncode.huffmanTree(array);
		System.out.println("�����������������Ϣ��");
		huffmanEncode.print(array);
		System.out.println("*********�����������************");
		Map<Byte, String> huffmanCode = HuffmanEncode.getHuffmanCode();
		for(Map.Entry<Byte, String> entry : huffmanCode.entrySet()) {
			System.out.printf("%c->%s\n",entry.getKey(),entry.getValue());
		}
		System.out.println("��������������ѹ����Ķ�����content:");
		byte[] afterZip = HuffmanEncode.zip(array);
		System.out.println("ת��Ϊbyte����������ݣ�");
		System.out.println(Arrays.toString(afterZip));
		System.out.println("����֮������ݣ�");
		byte[] afterDecode = HuffmanEncode.decode(afterZip);
		System.out.println(new String(afterDecode));
	}
	
	@Test
	public void fun3() {
		
		// -5 ԭ��  1000 0101 -> ���� 1111 1010 -> ���� 1111 1011
		/*System.out.println(Integer.toBinaryString(-1));
		System.out.println(HuffmanEncode.byteToBinaryString(true, (byte)1));
		System.out.println(HuffmanEncode.byteToBinaryString(true, (byte)-1));
		System.out.println(HuffmanEncode.byteToBinaryString(true, (byte)5));
		System.out.println(HuffmanEncode.byteToBinaryString(true, (byte)-5));*/
	}
	
	String src="G:\\src.png"; 
	String dest="G:\\src.zip";
	String newSrc="G:\\newSrc.png";
	
	/**
	 * 	�ļ�ѹ��
	 * @throws Exception 
	 */
	@Test
	public void fun4() throws Exception {
		
		HuffmanEncode encode=new HuffmanEncode();
		//ѹ��
		//encode.zipFile(src,dest);
		//��ѹ
		encode.unZipFile(dest, newSrc);
	}
}
