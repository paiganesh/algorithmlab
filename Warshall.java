/*
* Filename    : Warshall.java
* Problem Statement:
* Implementation of Warshall's algorithm.
* -------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.Arrays;
import java.util.Scanner;

public class Warshall {

    private static final int INFINITY = 99999;
    private int numberOfVertices, graph[][];

    public void readGraph()
    {
        int v1, v2, edge = 0;
        Scanner ip = new Scanner(System.in);

        System.out.print("Enter the number of vertices & edges: ");
        numberOfVertices = ip.nextInt();
        int numberOfEdges = ip.nextInt();

        graph = new int [numberOfVertices + 1][numberOfVertices + 1];
        for(int i = 1; i <= numberOfVertices; i++)
        {
            Arrays.fill(graph[i], INFINITY);
            graph[i][i] = 0;
        }

        while(edge++ != numberOfEdges)
        {
            System.out.print("Enter start & end vertex of edge " + edge + ": ");
            v1 = ip.nextInt();
            v2 = ip.nextInt();
            graph[v1][v2] = 1;
        }
    }

    public void computeShortestDistance()
    {
        for(int k = 1; k <= numberOfVertices; k++)
            for(int i = 1; i <= numberOfVertices; i++)
                for(int j = 1; j <= numberOfVertices; j++)
                    if(graph[i][k] == 1 && graph[k][j] == 1)
                        graph[i][j] = 1;
    }

    public void printTransitiveClosure()
    {
        for(int i = 1; i <= numberOfVertices; i++)
        {
            for(int j = 1; j <= numberOfVertices; j++)
            {
                if(i != j)
                    System.out.println(i + " to " + j + ": " + (graph[i][j]==INFINITY? "-" : graph[i][j]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Warshall w = new Warshall();
        w.readGraph();
        w.computeShortestDistance();

        System.out.println("\nTransitive Closure:");
        w.printTransitiveClosure();
    }
}
