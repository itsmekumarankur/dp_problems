package temp1;

import java.util.ArrayList;
import java.util.List;

class Graph{
	ArrayList<Node> listNodes ;
	ArrayList<Edge> listEdges;
	Graph(){
		this.listNodes = new ArrayList<Node>();
		this.listEdges  = new ArrayList<Edge>();
	}
	
	boolean addNode(String name){
		Node node = getNode(name);
		if(node!=null) {
			return false;
		}
		Node newNode = new Node(name);
		listNodes.add(newNode);
		return true;
	}
	
	List<Edge> getEdgeWithNode(Node node){
		List<Edge> listEdges = new ArrayList<Edge>();
		for(Edge edge: listEdges) {
			if(edge.srcNode.equals(node)) {
				listEdges.add(edge);
			}
			if(edge.destNode.equals(node)) {
				listEdges.add(edge);
			}
		}
		return listEdges;
	}
	
	boolean removeNode(String name) {
		Node node = getNode(name);
		if(node==null) {
			return false;
		}
		List<Edge>list = getEdgeWithNode(node);
		for(Edge edge: list) {
			listEdges.remove(edge);
		}
		listNodes.remove(node);
		return true;
	}
	
	addEdge(){
		
	}
	
	removeEdge(){
		
	}
	
	isNodePresent(){
		
	}
	Node getNode(String name){
		for(Node node: listNodes) {
			if(node.name.equals(name)){
				return node;
			}
		}
		return null;
	}
	
}

class Edge{
	Node srcNode;
	Node destNode;
	int distance;
	Edge(Node srcNode, Node destNode){
		this.srcNode = srcNode;
		this.destNode = destNode;
	}
}


class Node{
	String name;
	Node(String name){
		this.name = name;
		
	}
}

public class TestCode2{
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addNode("A");
	}
}