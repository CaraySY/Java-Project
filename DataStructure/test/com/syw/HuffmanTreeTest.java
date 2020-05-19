package com.syw;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;

import com.syw.huffman_encode.HuffmanEncode;
import com.syw.tree.HuffmanTree;

public class HuffmanTreeTest {

	/**
	 * 	构建和遍历哈夫曼树
	 */
	@Test
	public void fun1() {
		
		int[] array= {13,7,8,3,29,6,1};
		HuffmanTree tree=new HuffmanTree();
		tree.huffmanTree(array);
		tree.printHuffmanTree(array);
	}
	
	/**
	 * 	哈夫曼编码
	 */
	@Test
	public void fun2() {
		
		//String content="i like like like java do you like a java";
		String content="I am a Chinese, and I love China!!!";
		HuffmanEncode huffmanEncode=new HuffmanEncode();
		byte[] array=content.getBytes();
		huffmanEncode.huffmanTree(array);
		System.out.println("哈夫曼二叉树结点信息：");
		huffmanEncode.print(array);
		System.out.println("*********哈夫曼编码表************");
		Map<Byte, String> huffmanCode = HuffmanEncode.getHuffmanCode();
		for(Map.Entry<Byte, String> entry : huffmanCode.entrySet()) {
			System.out.printf("%c->%s\n",entry.getKey(),entry.getValue());
		}
		System.out.println("经过哈夫曼编码压缩后的二进制content:");
		byte[] afterZip = HuffmanEncode.zip(array);
		System.out.println("转换为byte数组里的数据：");
		System.out.println(Arrays.toString(afterZip));
		System.out.println("解码之后的数据：");
		byte[] afterDecode = HuffmanEncode.decode(afterZip);
		System.out.println(new String(afterDecode));
	}
	
	@Test
	public void fun3() {
		
		// -5 原码  1000 0101 -> 反码 1111 1010 -> 补码 1111 1011
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
	 * 	文件压缩
	 * @throws Exception 
	 */
	@Test
	public void fun4() throws Exception {
		
		HuffmanEncode encode=new HuffmanEncode();
		//压缩
		//encode.zipFile(src,dest);
		//解压
		encode.unZipFile(dest, newSrc);
	}
}
