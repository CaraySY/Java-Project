package com.syw;

import org.junit.Test;

import com.syw.graph.Graph;

public class GraphTest {

	@Test
	public void fun1() {
		
		String[] vertexs= {"A","B","C","D","E"};
		Graph graph=new Graph(5);
		for(String vertex : vertexs) {
			graph.add(vertex);
		}
		graph.insertEdge("B", "E", 1);
		graph.insertEdge("B", "C", 1);
		graph.insertEdge("B", "D", 1);
		graph.insertEdge("B", "A", 1);
		graph.insertEdge("C", "A", 1);
		graph.printEdges();
		//graph.dfs();
		graph.bfs();
	}
	
	/**
	 * 	深度优先dfs和广度优先bfs
	 */
	@Test
	public void fun2() {
		
		String[] vertexs= {"A","B","C","D","E","F","G","H"};
		Graph graph=new Graph(8);
		for(String vertex : vertexs) {
			graph.add(vertex);
		}
		graph.insertEdge("A", "B", 1);
		graph.insertEdge("A", "C", 1);
		graph.insertEdge("B", "D", 1);
		graph.insertEdge("B", "E", 1);
		graph.insertEdge("E", "H", 1);
		graph.insertEdge("D", "H", 1);
		graph.insertEdge("C", "F", 1);
		graph.insertEdge("C", "G", 1);
		graph.printEdges();
		System.out.println("深度优先算法:");
		//graph.dfs();
		System.out.println("\n广度优先算法：");
		graph.bfs();
	}
	
	@Test
	public void fun3() {
		
		System.out.println('A' % 7);
		System.out.println('B' % 7);
		System.out.println('C' % 7);
		System.out.println('D' % 7);
		System.out.println('E' % 7);
		System.out.println('F' % 7);
		System.out.println('G' % 7);
	}
}
