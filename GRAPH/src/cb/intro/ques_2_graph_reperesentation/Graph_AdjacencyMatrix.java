package cb.set1.ques_2_graph_reperesentation;

public class Graph_AdjacencyMatrix {

	int[][] arr;
	
	public Graph_AdjacencyMatrix(int size){
		arr = new int[size][size];
	}
	
	public void addNode(int node1, int node2, boolean bidirectional ) {
		arr[node1][node2] = 1;
		if(bidirectional) {
			arr[node2][node1] = 1;
		}
	}
	
	public void removeEdge(int node1, int node2, boolean bidirectional){
		if(arr[node1][node2]==0) {
			// throw exception
		}
		if(bidirectional) {
			if(arr[node2][node1]==0) {
				//throw exception
			}
		}
	}
	
	public boolean isEdgeExist(int node1, int node2){
		
	}
		
}
