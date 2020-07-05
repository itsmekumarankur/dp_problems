package cb.practise_intro.ques_2_graph_reperesentation;

import java.util.ArrayList;

class Graph {
	ArrayList<Node> allNodes;
	
	Graph(){
		allNodes = new ArrayList<>();
	}
	
	void addNode(String nodeName) {
		// create a new node
		Node node = new Node(name);
		// add node to arralist
		allNodes.add(node);
	}
	
	void removeNode(String nodeName) {
		
	}
	
	void AddEdge(String node1Name, String node2Name) {
		
	}
	
	void removeEdge(String node1Name, STring node2Name) {
		
	}
	
	boolean isNodePresent(String nodeName){
		
	}
}


class Node{
	Node[] edgeNodes;
	String name;
	Node(String name){
		edgeNodes = new Node[10];
		this.name = name;
	}
}

public class TestCode{
	Graph g =  new Graph();
	
	g.addNodes("Delhi");
}