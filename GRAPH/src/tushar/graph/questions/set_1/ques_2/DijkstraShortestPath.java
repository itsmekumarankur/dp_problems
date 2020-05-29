package tushar.graph.questions.set_1.ques_2;

import tushar.graph.questions.BinaryMinHeap;
import tushar.graph.questions.Edge;
import tushar.graph.questions.Graph;
import tushar.graph.questions.Vertex;

import java.util.HashMap;
import java.util.Map;

/**
 *         Find single source shortest path using Dijkstra's algorithm
 *
 *         Space complexity - O(E + V) Time complexity - O(ElogV)
 */
public class DijkstraShortestPath {

	public Map<Vertex<Integer>, Integer> shortestPath(Graph<Integer> graph, Vertex<Integer> sourceVertex) {
		BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();
		Map<Vertex<Integer>, Integer> distance = new HashMap<>();
		Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();
		for (Vertex<Integer> vertex : graph.getAllVertex()) {
			minHeap.add(Integer.MAX_VALUE, vertex);
		}
		minHeap.decrease(sourceVertex, 0);
		distance.put(sourceVertex, 0);
		parent.put(sourceVertex, null);
		while (!minHeap.empty()) {
			BinaryMinHeap<Vertex<Integer>>.Node heapNode = minHeap.extractMinNode();
			Vertex<Integer> current = heapNode.key;
			distance.put(current, heapNode.weight);
			for (Edge<Integer> edge : current.getEdges()) {
				Vertex<Integer> adjacent = getVertexForEdge(current, edge);
				if (!minHeap.containsData(adjacent)) {
					continue;
				}
				int newDistance = distance.get(current) + edge.getWeight();
				if (minHeap.getWeight(adjacent) > newDistance) {
					minHeap.decrease(adjacent, newDistance);
					parent.put(adjacent, current);
				}
			}
		}
		return distance;
	}

	private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e) {
		return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
	}

}