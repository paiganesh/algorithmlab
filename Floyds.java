/*
* Filename    : Floyds.java
* Problem Statement:
* Implementation of All-Pairs Shortest Paths problem using Floyd's algorithm.
* -------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.Arrays;
import java.util.Scanner;

public class Floyds {

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
            System.out.print("Enter the weight of the edge [" + v1 + "--->" + v2 + "]: ");
            graph[v1][v2] = ip.nextInt();
        }
    }

    public void computeShortestDistance()
    {
        for(int k = 1; k <= numberOfVertices; k++)
            for(int i = 1; i <= numberOfVertices; i++)
                for(int j = 1; j <= numberOfVertices; j++)
                    graph[i][j] = Math.min(graph[i][j] , graph[i][k] + graph[k][j]);
    }

    public void printShortestDistance()
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
        Floyds floyd = new Floyds();
        floyd.readGraph();
        floyd.computeShortestDistance();

        System.out.println("\nAll-pair Shortest Path");
        floyd.printShortestDistance();
    }
}
