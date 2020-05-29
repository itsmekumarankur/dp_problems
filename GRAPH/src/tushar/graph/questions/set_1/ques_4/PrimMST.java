package tushar.graph.questions.set_1.ques_4;

import java.util.*;

import tushar.graph.questions.BinaryMinHeap;
import tushar.graph.questions.Edge;
import tushar.graph.questions.Graph;
import tushar.graph.questions.Vertex;

/**
 * Find minimum spanning tree using Prim's algorithm
 *
 * Space complexity - O(E + V)
 * Time complexity - O(ElogV)
 */
public class PrimMST {
    public List<Edge<Integer>> primMST(Graph<Integer> graph){
        BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();
        Map<Vertex<Integer>,Edge<Integer>> vertexToEdge = new HashMap<>();
        List<Edge<Integer>> result = new ArrayList<>();
        for(Vertex<Integer> v : graph.getAllVertex()){
            minHeap.add(Integer.MAX_VALUE, v);
        }
        Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
        minHeap.decrease(startVertex, 0);
        while(!minHeap.empty()){
            Vertex<Integer> current = minHeap.extractMin();
            Edge<Integer> spanningTreeEdge = vertexToEdge.get(current);
            if(spanningTreeEdge != null) {
                result.add(spanningTreeEdge);
            }
            for(Edge<Integer> edge : current.getEdges()){
                Vertex<Integer> adjacent = getVertexForEdge(current, edge);
                if(minHeap.containsData(adjacent) && minHeap.getWeight(adjacent) > edge.getWeight()){
                    minHeap.decrease(adjacent, edge.getWeight());
                    vertexToEdge.put(adjacent, edge);
                }
            }
        }
        return result;
    }

    private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e){
        return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
    }
}