/*
* FILENAME    : TopologicalSorting.java
* Problem Statement:
* Topological Sorting of Vertices in a given Directed Graph
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.Scanner;

public class TopologicalSorting
{
    private int graph[][], noOfVertices, order[];

    public void readGraph()
    {
        Scanner ip = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices & edges: ");
        this.noOfVertices = ip.nextInt();
        int numberOfEdges = ip.nextInt();

        graph = new int[noOfVertices + 1][noOfVertices + 1];
        order = new int[noOfVertices + 1];
        
        System.out.println("\nEnter " + numberOfEdges + " edges:");
        for(int edge = 0; edge < numberOfEdges; ++edge)
        {
            System.out.println("Enter start & end vertex of edge: " + (edge + 1));
            graph[ip.nextInt()][ip.nextInt()] = 1;
        }
    }

    public void sort()
    {
        int count = 0;
        int indegree []    = new int[noOfVertices + 1];
        boolean visited [] = new boolean[noOfVertices + 1];

        for(int i = 1; i <= noOfVertices; i++)
            for(int j = 1; j <= noOfVertices; j++)
                if(graph[j][i] == 1)
                    indegree[i]++; // calaculating indegree by adding incoming edges

        while(count < noOfVertices)
        {
            for(int k = 1; k <= noOfVertices; k++)
                if( (indegree[k] == 0) && !visited[k])
                {
                    order[count++] = k;    // write k th vertex
                    visited[k] = true;
                    for(int i = 1; i <= noOfVertices; i++)
                        if( graph[k][i] == 1)
                            indegree[i]--;
                }
        }
    }

    public void printOrder()
    {
        System.out.print("\nTopological Sorted Order: ");
        for(int i = 0; i < noOfVertices; i++)
            System.out.print(order[i] + " ");
    }

    public static void main(String[] args)
    {
        TopologicalSorting ts = new TopologicalSorting();
        ts.readGraph();
        ts.sort();
        ts.printOrder();
    }
}
