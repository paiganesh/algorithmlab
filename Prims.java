/*
* Filename    : Prims.java
* Problem Statement: 
* Find Minimum Cost Spanning Tree of a given undirected graph using Prim's algorithm.
* -------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.*;

public class Prims {
    public final int INFINITY = Integer.MAX_VALUE;
    private int noOfVertices, weight[][], cost = 0;
    private ArrayList <Edge> treeEdges = new ArrayList<>();
        
    private class Edge {  
        Integer n1, n2, weight;        
        Edge(Integer n1, Integer n2, Integer weight) {
            this.n1 = n1;
            this.n2 = n2;
            this.weight = weight;
        }
    }

    public void readGraph() {
        int n1, n2, edge = 0;
        Scanner ip = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices & edges: ");
        noOfVertices = ip.nextInt();
        int numberOfEdges = ip.nextInt();
        
        //Initialize variables
        weight = new int [noOfVertices + 1][noOfVertices + 1];
        for(int i = 1; i <= noOfVertices; i++)
        {
            Arrays.fill(weight[i], INFINITY);
            weight[i][i] = 0;
        }

        while(edge++ != numberOfEdges)
        {
            System.out.print("Enter start vertex, end vertex and weight of edge " + edge + ": ");
            n1 = ip.nextInt();
            n2 = ip.nextInt();
            weight[n1][n2] = weight[n2][n1] = ip.nextInt();
        }
    }
    
    private void computeSpanningTree(Integer sourceNode) {
        ArrayList <Integer> graphNodes = new ArrayList<>(), treeNodes = new ArrayList<>();
        ArrayList <Edge> candidateEdges = new ArrayList<>();

        //Compute Spanning Tree
        for(Integer i=1; i<=noOfVertices; i++)
            graphNodes.add(i);
        graphNodes.remove(sourceNode);
        treeNodes.add(sourceNode);
        
        for(int treeEdgeCount = 1; treeEdgeCount <= (noOfVertices - 1); treeEdgeCount++)
        {
            for (Integer n1 : treeNodes) 
                for (Integer n2 : graphNodes)
                    if (weight[n1][n2] != INFINITY)
                        candidateEdges.add(new Edge(n1, n2, weight[n1][n2]));
            Edge minEdge = Collections.min(candidateEdges, (e1, e2) -> { return e1.weight - e2.weight; });
            candidateEdges.clear();
            graphNodes.remove(minEdge.n2);
            treeNodes.add(minEdge.n2);
            treeEdges.add(minEdge);
            cost += minEdge.weight;
        }
    }
    
    public void printSpanningTree(Integer sourceNode) {        
        computeSpanningTree(sourceNode);

        //Print spanning tree edges and cost
        System.out.println("\n\nEdges of the Spanning Tree:\n");
        for (Edge edge : treeEdges) 
            System.out.println("  Edge [ " + edge.n1 + " --- " + edge.n2 + " ] Cost: " + edge.weight);
        System.out.println("\nCost of Minimum Spanning Tree: " + cost + " units\n\n");        
    }
    
    public static void main(String[] args) {
        Prims st = new Prims();
        st.readGraph();
        
        System.out.print("\nEnter a source vertex: ");
        int sourceVertex = new Scanner(System.in).nextInt();
        
        st.printSpanningTree(sourceVertex);
    }
}
