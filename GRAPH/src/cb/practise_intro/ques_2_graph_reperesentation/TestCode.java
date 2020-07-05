package cb.practise_intro.ques_2_graph_reperesentation;

import java.util.ArrayList;

class Graph {
	ArrayList<Node> allNodes;

	Graph() {
		allNodes = new ArrayList<Node>();
	}

	boolean addNode(String nodeName) {
		Node node = getNodeByName(nodeName);
		if (node != null) {
			return false;
		}
		Node newNode = new Node(nodeName);
		allNodes.add(newNode);
		return true;
	}

	boolean removeNode(String nodeName) {
		Node node = getNodeByName(nodeName);
		if (node == null) {
			System.out.println("Node " + nodeName + " not preset");
			return false;
		} else {
			allNodes.remove(node);
			System.out.println("Node " + nodeName + " removed");
			return true;
		}
	}

	Node getNodeByName(String nodeName) {
		for (Node node : allNodes) {
			if (node.name.equalsIgnoreCase(nodeName)) {
				return node;
			}
		}
		return null;
	}

	boolean AddEdge(String node1Name, String node2Name) {

		Node node1 = getNodeByName(node1Name);
		Node node2 = getNodeByName(node2Name);

		if (node1 == null || node2 == null) {
			return false;
		}

		node1.edgeNodes.add(node2);
		node2.edgeNodes.add(node1);
		return true;

	}

	void removeEdge(String node1Name, String node2Name) {

	}

	boolean isNodePresent(String nodeName) {
		Node node = getNodeByName(nodeName);
		if (node == null) {
			return false;
		}
		return true;
	}
}

class Node {
	ArrayList<Node> edgeNodes;
	String name;

	Node(String name) {
		edgeNodes = new ArrayList<Node>();
		this.name = name;
	}
}

public class TestCode {

	public static void main(String[] args) {
		Graph g = new Graph();

		g.addNode("Delhi");
		g.addNode("Bangalore");
		g.addNode("Mumbai");
		g.removeNode("Agra");
		g.removeNode("Calcutta");
		g.removeNode("Delhi");
		g.removeNode("bangalore");
		g.addNode("Delhi");
		if(g.isNodePresent("Agra")) {
			System.out.println("Present");
		}
		g.addNode("Delhi");
		g.addNode("Bangalore");
		g.AddEdge("Delhi", "Mumbai");
		g.AddEdge("Mumbai", "Bangalore");

	}

}
