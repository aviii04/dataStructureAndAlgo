package graph.traversal.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Vertex{
    String value;
    boolean isVisited;

    List<Vertex> neighbor;

    Vertex(String value){
        this.value = value;
        this.neighbor = new ArrayList<>();
    }

    public void addNeighbor(Vertex neighbor) {
        this.neighbor.add(neighbor);
    }
}

public class DepthFirstSearch {

    public void traverse(List<Vertex> vertexList){
        if(vertexList == null || vertexList.isEmpty()) return;

        for(Vertex v: vertexList){
            if(!v.isVisited){
                dfsHelper(v);
            }
        }
    }

    private void dfsHelper(Vertex vertex) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(vertex);
        vertex.isVisited = true;

        Vertex currentVertex;
        while (!stack.isEmpty()) {
            currentVertex = stack.pop();
            System.out.print(currentVertex.value+" ");

            for (Vertex v : currentVertex.neighbor) {
                if (!v.isVisited) {
                    stack.push(v);
                    v.isVisited = true;
                }
            }
        }
    }
}

class DepthFirstSearchRecursion{

    public void traverse(List<Vertex> vertexList){
        if(vertexList == null || vertexList.isEmpty()) return;

        for(Vertex v: vertexList){
            if(!v.isVisited){
                dfsHelper(v);
            }
        }
    }

    private void dfsHelper(Vertex vertex) {
        System.out.print(vertex.value);

        for(Vertex v: vertex.neighbor){
            if(!v.isVisited){
                v.isVisited = true;
                dfsHelper(v);
            }
        }
    }

}

class Test{
    public static void main(String[] args){

        DepthFirstSearch dfs = new DepthFirstSearch();
        DepthFirstSearchRecursion dfsRecursion = new DepthFirstSearchRecursion();
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");
        Vertex v6 = new Vertex("F");
        Vertex v7 = new Vertex("G");
        Vertex v8 = new Vertex("H");

        List<Vertex> list = new ArrayList<>();
        v1.addNeighbor(v2);
        v1.addNeighbor(v6);
        v1.addNeighbor(v7);
        v2.addNeighbor(v3);
        v2.addNeighbor(v4);
        v4.addNeighbor(v5);
        v7.addNeighbor(v8);

        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);
        list.add(v6);
        list.add(v7);
        list.add(v8);

        dfs.traverse(list);
        System.out.println();

//         Recursion method
//         dfsRecursion.traverse(list);

    }
}
