package tushar.graph.questions.set_2.ques_7;

import java.util.Scanner;

/**
 * Date 11/05/2015
 * 
 * @author Tushar Roy
 *
 *         Write program for Bellman Ford algorithm to find single source
 *         shortest path in directed graph. Bellman ford works with negative
 *         edges as well unlike Dijksra's algorithm. If there is negative weight
 *         cycle it detects it.
 */

class Edge {
	int src, dest, weight;
};

class Graph {
	final int inf = Integer.MAX_VALUE;
	int v, e;
	Edge[] edge;

	Graph(int v, int e) {
		this.v = v;
		this.e = e;
		edge = new Edge[e];
	}

	void addEdge(int u, int v, int w, int count) {
		edge[count].src = u;
		edge[count].dest = v;
		edge[count].weight = w;
	}

	void Bellmanford(int src) {
		int distance[] = new int[v];
		for (int i = 0; i < v; i++) {
			if (i == src) {
				distance[i] = 0;
			} else {
				distance[i] = inf;
			}
		}
		// Rekaxation time
		for (int i = 1; i <= v - 1; i++) {
			for (int j = 0; j < e; j++) {
				int src = edge[j].src;
				int dest = edge[j].dest;
				int wt = edge[j].weight;

				// Relaxation check;
				if (distance[src] != inf && distance[src] + wt < distance[dest]) {
					distance[dest] = distance[src] + wt;
				}
			}
		}
		// check for negative weight cycle
		for (int j = 0; j < e; j++) {
			int src = edge[j].src;
			int dest = edge[j].dest;
			int wt = edge[j].weight;

			// Relaxation check;
			if (distance[src] != inf && distance[src] + wt < distance[dest]) {
				// distance[dest] = distance[src] + wt;
				System.out.println("Graph has negative cycle");
				return;
			}
		}
		for (int i = 0; i < v; i++) {
			System.out.println(i + "  " + distance[i]);
		}
		return;
	}

	public static void main(String[] args) {
		int v, e;
		Scanner s = new Scanner(System.in);
		v = s.nextInt();
		e = s.nextInt();

		Graph g = new Graph(v, e);
		for (int i = 0; i < e; i++) {
			int u, v, w;
			u = s.nextInt();
			v = s.nextInt();
			w = s.nextInt();

			g.addEdge(u, v, w, i);
		}
		g.Bellmanford(0);

	}

}