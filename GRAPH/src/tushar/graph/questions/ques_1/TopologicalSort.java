package tushar.graph.questions.ques_1;
import tushar.graph.questions.Graph;
import tushar.graph.questions.Vertex;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *         Given a directed acyclic graph, do a topological sort on this graph.
 *         Do DFS by keeping visited.
 */
public class TopologicalSort<T> {

	public Stack<Vertex<T>> topSort(Graph<T> graph) {
		Stack<Vertex<T>> stack = new Stack<>();
		Set<Vertex<T>> visited = new HashSet<>();
		for (Vertex<T> vertex : graph.getAllVertex()) {
			if (visited.contains(vertex)) {
				continue;
			}
			topSortUtil(vertex, stack, visited);
		}
		return stack;
	}

	private void topSortUtil(Vertex<T> vertex, Stack<Vertex<T>> stack, Set<Vertex<T>> visited) {
		visited.add(vertex);
		for (Vertex<T> childVertex : vertex.getAdjacentVertexes()) {
			if (visited.contains(childVertex)) {
				continue;
			}
			topSortUtil(childVertex, stack, visited);
		}
		stack.push(vertex);
	}

	public static void main(String args[]) {
		Graph<Integer> graph = new Graph<>(true);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(5, 6);
		graph.addEdge(6, 3);
		graph.addEdge(3, 8);
		graph.addEdge(8, 11);

		TopologicalSort<Integer> sort = new TopologicalSort<Integer>();
		Stack<Vertex<Integer>> result = sort.topSort(graph);
		while (!result.isEmpty()) {
			System.out.println(result.pop());
		}
	}
}