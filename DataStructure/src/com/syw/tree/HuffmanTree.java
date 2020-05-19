package com.syw.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public void huffmanTree(int[] array) {
		
		Node node = createHuffmanTree(array);
		System.out.println("���ڵ��Ȩֵ:"+node);
	}
	
	public void printHuffmanTree(int[] array) {
		
		Node node = createHuffmanTree(array);
		node.preOrder();
		System.out.println();
	}
	
	/**
	 * @param array �ڵ��Ȩֵ
	 */
	private Node createHuffmanTree(int[] array) {
		
		//1�������������Ľڵ㣬���Ҽ��뵽ArrayList������
		List<Node> nodes=new ArrayList<>();
		for(int value:array) {
			nodes.add(new Node(value));
		}
		//2������������������Ҫ���������Ľڵ��Ȩֵ��С��������
		Collections.sort(nodes);
		//3����ArrayList��ֻʣ�����һ���ڵ㣬����ѭ�������һ���ڵ���ǹ��������ĸ��ڵ�
		while(nodes.size() > 1) {
			Node leftNode=nodes.get(0);//��ڵ�
			Node rightNode=nodes.get(1);//�ҽڵ�
			//4�����ڵ���������ӽڵ��Ȩֵ֮��
			Node parentNode=new Node(leftNode.value+rightNode.value);
			//5�����ڵ�ָ�����ҽڵ�
			parentNode.left=leftNode;
			parentNode.right=rightNode;
			//6������ǰ�������������������ӽڵ�Ӽ������Ƴ�
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//7�����ڵ���뵽�����м���������������
			nodes.add(parentNode);
			//8����������
			Collections.sort(nodes);
		}
		return nodes.get(0); //���ش����Ĺ����������ڵ�
	}
	
	private class Node implements Comparable<Node>{
		
		private int value;//����������Ȩֵ
		private Node left; //������ڵ�
		private Node right; //�����ҽڵ�
		
		public Node(int value) {
			this.value = value;
		}

		//ʹ�õݹ�ǰ�������������
		public void preOrder() {
			
			if(this!=null) {
				System.out.print(this+"->");
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
			return "Node [value=" + value + "]";
		}

		@Override
		public int compareTo(Node o) {

			/*�ܹ�ʹ�ü��ϵ�������(��С����)��ǰ��Ӹ��ŴӴ�С*/
			return this.value-o.value;
		}
	}
}
