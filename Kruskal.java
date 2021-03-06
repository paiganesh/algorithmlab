/*
* Filename    : Kruskal.java
* Problem Statement: 
* Find Minimum Cost Spanning Tree of a given undirected graph using Kruskal's algorithm
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.*;

public class Kruskal {
    private class Edge {  int v1, v2, weight;  }
    private ArrayList<Edge> edgeList = new ArrayList<>(), minEdgeList = new ArrayList<>();
    private int noOfVertices, cost = 0;
    
    public void readGraph() {
        int edge = 0;
        Scanner ip = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices & edges: ");
        noOfVertices = ip.nextInt();
        int numberOfEdges = ip.nextInt();
        
        while(edge++ != numberOfEdges)
        {
            Edge e = new Edge();
            System.out.print("Enter start vertex, end vertex and weight of edge " + edge + ": ");
            e.v1 = ip.nextInt();
            e.v2 = ip.nextInt();
            e.weight = ip.nextInt();
            edgeList.add(e);
        }
    }

    private int find(int parent[], int x) {
        if(parent[x] == -1)
            return x;
        return find(parent, parent[x]);
    }
    
    private void union(int parent[], int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        parent[xRoot] = yRoot;
    }

    private void computeSpanningTree() {
        int treeEdgeCount = 0, parent[] = new int[noOfVertices + 1];
        Arrays.fill(parent, -1);
        
        //Find spanning tree from the graph
        edgeList.sort((e1, e2) -> { return e1.weight - e2.weight; });
        while(treeEdgeCount < noOfVertices - 1)
        {
            Edge minEdge = edgeList.get(0);
            if(find(parent, minEdge.v1) != find(parent, minEdge.v2))
            {
                union(parent, minEdge.v1, minEdge.v2);
                minEdgeList.add(minEdge);
                cost += minEdge.weight;
                treeEdgeCount++;
            }
            edgeList.remove(minEdge);
        }
    }
    
    public void printSpanningTree() {
        computeSpanningTree();

        //Print spanning tree edges and cost
        System.out.println("\n\nEdges of the Spanning Tree:\n");
        for (Edge edge : minEdgeList) 
            System.out.println("  Edge [ " + edge.v1 + " --- " + edge.v2 + " ] Cost: " + edge.weight);
        System.out.println("\nCost of Minimum Spanning Tree: " + cost + " units\n\n");        
    }
    
    public static void main(String[] args) {
        Kruskal st = new Kruskal();
        st.readGraph();
        st.printSpanningTree();
    }
}
