package graph.topologicalOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Vertex {
    String name;
    boolean isVisited;
    List<Vertex> neighbours;
    Vertex(String name){
        this.name = name;
        neighbours = new ArrayList<>();
    }
}

public class TopologicalOrder {
    Stack<Vertex> stack = new Stack<>();

    public void sortByTopologicalOrder(List<Vertex> graph){
        if(graph == null || graph.isEmpty()) return;

        for (Vertex v : graph){
            if(!v.isVisited)
                dfs(v);
        }

        // Print stack
        while(!stack.isEmpty()){
            System.out.print(stack.pop().name+" ");
        }
    }

    private void dfs(Vertex u){
        u.isVisited = true;

        for(Vertex v : u.neighbours){
            if(!v.isVisited)
                dfs(v);
        }

        stack.push(u);
    }
}

class Test{
    public static void main(String[] args){
        TopologicalOrder ordering = new TopologicalOrder();

        List<Vertex> graph = new ArrayList<>();

        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).neighbours.add(graph.get(3));

        graph.get(3).neighbours.add(graph.get(1));

        graph.get(4).neighbours.add(graph.get(0));
        graph.get(4).neighbours.add(graph.get(1));

        graph.get(5).neighbours.add(graph.get(0));
        graph.get(5).neighbours.add(graph.get(2));

        ordering.sortByTopologicalOrder(graph);


    }
}
