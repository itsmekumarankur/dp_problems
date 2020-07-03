package tushar.graph.questions.set_1.ques_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tushar.graph.questions.Edge;
import tushar.graph.questions.Graph;
import tushar.graph.questions.Vertex;
import tushar.graph.questions.set_1.ques_5.DisjointSet;

/**
 *         Find minimum spanning tree usinig Kruskals algorithm
 *         Time complexity - O(ElogE)
 *         Space complexity - O(E + V)
 */

public class KruskalMST {
    /**
     * Comparator to sort edges by weight in non decreasing order
     */
    public class EdgeComparator implements Comparator<Edge<Integer>> {
        @Override
        public int compare(Edge<Integer> edge1, Edge<Integer> edge2) {
            if (edge1.getWeight() <= edge2.getWeight()) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public List<Edge<Integer>> getMST(Graph<Integer> graph) {
        List<Edge<Integer>> allEdges = graph.getAllEdges();
        EdgeComparator edgeComparator = new EdgeComparator();

        Collections.sort(allEdges, edgeComparator);
        DisjointSet disjointSet = new DisjointSet();

        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            disjointSet.makeSet(vertex.getId());
        }

        List<Edge<Integer>> resultEdge = new ArrayList<Edge<Integer>>();

        for (Edge<Integer> edge : allEdges) {
            //get the sets of two vertices of the edge
            long root1 = disjointSet.findSet(edge.getVertex1().getId());
            long root2 = disjointSet.findSet(edge.getVertex2().getId());
            if (root1 == root2) {
                continue;
            } else {
                //if vertices are in different set then add the edge to result and union these two sets into one
                resultEdge.add(edge);
                disjointSet.union(edge.getVertex1().getId(), edge.getVertex2().getId());
            }

        }
        return resultEdge;
    }

}