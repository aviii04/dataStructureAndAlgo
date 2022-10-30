package graph.cycle;

import java.util.ArrayList;
import java.util.List;

class Vertex{
    String name;
    boolean isBeingVisited;
    boolean visited;
    List<Vertex> neighbours;
    Vertex(String name){
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

}
// Runtime complexity: O(V+E)
public class CycleDetection {
    public static void detectCycle(List<Vertex> graph){
        if (graph == null){
            System.out.println("Empty Graph");
            return;
        }
        for(Vertex vertex: graph){
            if(!vertex.visited){
                dfs(vertex);
            }
        }
    }

    public static void dfs(Vertex vertex){
        vertex.isBeingVisited = true;

        vertex.neighbours.forEach(neighbour -> {
            if(neighbour.isBeingVisited){
                System.out.println("Backward edge detected, hence Cycle exist");
                return;
            }
            if(!neighbour.visited){
                dfs(neighbour);
            }
        });

        vertex.isBeingVisited = false;
        vertex.visited = true;
    }
}

class Test{
    public static void main(String[] args){

        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");
        Vertex v3 = new Vertex("D");
        Vertex v4 = new Vertex("E");
        Vertex v5 = new Vertex("F");

        // we have to handle the connections
        v5.neighbours.add(v0);
        v0.neighbours.add(v4);
        v0.neighbours.add(v2);
        v4.neighbours.add(v5); // Comment out for no-cycle in graph
        v2.neighbours.add(v1);
        v2.neighbours.add(v3);

        List<Vertex> graph = new ArrayList<>();
        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        CycleDetection.detectCycle(graph);
    }
}
