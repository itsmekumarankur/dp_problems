package tushar.graph.questions.set_2.ques_9;

/**
 * Date 11/02/2015
 * 
 * @author Tushar Roy
 *
 */
public class FloydWarshallAllPairShortestPath {

	static int V = 4;
	static final int INF = Integer.MAX_VALUE;

	static void floydWarshall(int graph[][]) {

		int dist[][] = new int[V][V];
		int i, j, k;

		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				dist[i][j] = graph[i][j];

		for (k = 0; k < V; k++) {
			for (i = 0; i < V; i++) {
				for (j = 0; j < V; j++) {
					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		printSolution(dist);
	}

	static void printSolution(int dist[][]) {
		System.out.println(
				"The following matrix shows the shortest distances\"\r\n" + "	\" between every pair of vertices \\n");

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (dist[i][j] == INF)
					System.out.println("INF ");
				else
					System.out.println(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String arg[]) {

		int graph[][] = { { 0, 5, INF, 10 }, { INF, 0, 3, INF }, { INF, INF, 0, 1 }, { INF, INF, INF, 0 } };

		// Print the solution
		floydWarshall(graph);

	}
}