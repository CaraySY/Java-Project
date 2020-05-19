package com.syw.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public void huffmanTree(int[] array) {
		
		Node node = createHuffmanTree(array);
		System.out.println("根节点的权值:"+node);
	}
	
	public void printHuffmanTree(int[] array) {
		
		Node node = createHuffmanTree(array);
		node.preOrder();
		System.out.println();
	}
	
	/**
	 * @param array 节点的权值
	 */
	private Node createHuffmanTree(int[] array) {
		
		//1、创建二叉树的节点，并且加入到ArrayList集合中
		List<Node> nodes=new ArrayList<>();
		for(int value:array) {
			nodes.add(new Node(value));
		}
		//2、构建哈夫曼树，需要将待构建的节点的权值从小到大排序
		Collections.sort(nodes);
		//3、当ArrayList中只剩下最后一个节点，跳出循环，最后一个节点就是哈夫曼树的根节点
		while(nodes.size() > 1) {
			Node leftNode=nodes.get(0);//左节点
			Node rightNode=nodes.get(1);//右节点
			//4、父节点就是左右子节点的权值之和
			Node parentNode=new Node(leftNode.value+rightNode.value);
			//5、父节点指向左右节点
			parentNode.left=leftNode;
			parentNode.right=rightNode;
			//6、将当前构建哈夫曼树的左右子节点从集合中移除
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//7、父节点加入到集合中继续构建哈夫曼树
			nodes.add(parentNode);
			//8、重新排序
			Collections.sort(nodes);
		}
		return nodes.get(0); //返回创建的哈夫曼树根节点
	}
	
	private class Node implements Comparable<Node>{
		
		private int value;//哈夫曼树的权值
		private Node left; //树的左节点
		private Node right; //树的右节点
		
		public Node(int value) {
			this.value = value;
		}

		//使用递归前序遍历哈夫曼树
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

			/*能够使用集合的排序功能(从小到大)，前面加负号从大到小*/
			return this.value-o.value;
		}
	}
}
