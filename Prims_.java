/*
* Filename    : Prims_.java
* Problem Statement: 
* Find Minimum Cost Spanning Tree of a given undirected graph using Prim's algorithm.
* -------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.*;

public class Prims_ {

    public final int INFINITY = 99999;
    private int noOfVertices, weight[][];

    public void readGraph()
    {
        int v1, v2, edge = 0;
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
            v1 = ip.nextInt();
            v2 = ip.nextInt();
            weight[v1][v2] = weight[v2][v1] = ip.nextInt();
        }
    }

    public void printSpanningTree(int sourceNode)
    {        
        boolean treeNode[] = new boolean[noOfVertices + 1];
        treeNode[sourceNode] = true;
        int cost = 0;
        
        //for all n-1 edges of the graph
        for(int treeEdgeCount = 1; treeEdgeCount <= (noOfVertices - 1); treeEdgeCount++)
        {
            int v1 = 0, v2 = 0, min = INFINITY;
            for(int u = 1; u <= noOfVertices; u++)    //for every node u in the tree
            {
                if(treeNode[u])
                {
                    //find nearest node v adjacent to the tree nodes
                    for(int v = 1; v <= noOfVertices; v++)
                        if(!treeNode[v] && (weight[u][v] < min))
                        {
                            min = weight[u][v];
                            v1 = u;
                            v2 = v;
            }    }      }

            treeNode[v2] = true;
            System.out.println("  Edge " + treeEdgeCount + ": [ " + v1 + " --- " + v2 + " ] Cost: " + weight[v1][v2]);
            cost += weight[v1][v2];
        }
        System.out.println("\nCost of Minimum Spanning Tree: " + cost + " units\n\n");
    }
    
    public static void main(String[] args) {
        Prims_ st = new Prims_();
        st.readGraph();
        
        System.out.print("\nEnter a source vertex: ");
        int sourceVertex = new Scanner(System.in).nextInt();
        
        st.printSpanningTree(sourceVertex);
    }
}
