


class Graph{
	int[][] graphArray;
	boolean bidirectional;
	
	Graph(int size, boolean bidirectional){
		graphArray = new int[size][size];
		this.bidirectional = bidirectional;
	}
	
	
	boolean addEdge(int src, int dest) {
		if(graphArray[src][dest]==1) {
			return false;
		}
		graphArray[src][dest] = 1;
		if(bidirectional) {
			graphArray[dest][src] = 1;
		}
		return true;
	}
//	
//	boolean removeEdge(int src, int dest) {
//		
//	}
//	
//	boolean isEdgePresent(int src, int dest){
//		
//	}
	
	
	void printGraph() {
		
	}
}


public class GraphTest{
	public static void main(String[] args) {
	
		Graph g = new Graph(5, true);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 1);
		
	}
}