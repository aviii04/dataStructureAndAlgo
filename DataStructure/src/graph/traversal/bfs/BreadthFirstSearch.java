package graph.traversal.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex{
    int name;
    boolean isVisited;
    List<Vertex> neighbors;

    Vertex(int name){
        this.name = name;
        neighbors = new ArrayList<>();
    }
}

class BreadthFirstSearch {

    public void traverse(Vertex vertex) {
        if (vertex == null) return;

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertex);
        vertex.isVisited = true;

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.remove();
            System.out.print(currentVertex.name+" ");

            for (Vertex v : currentVertex.neighbors) {
                if (!v.isVisited) {
                    queue.add(v);
                    v.isVisited = true;
                }
            }
        }
    }

}

class Test{
    public static void main(String[] args) {

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        vertex1.neighbors.add(vertex2);
        vertex1.neighbors.add(vertex4);
        vertex4.neighbors.add(vertex5);
        vertex2.neighbors.add(vertex3);

        breadthFirstSearch.traverse(vertex1);

    }
}