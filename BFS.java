/*
* FILENAME    : BFS.java
* Problem Statement: Implementation of BFS Algorithm
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Queue;

public class BFS {
    int a[][], noOfVertices;

    public BFS()
    {
        Scanner ip = new Scanner(System.in);

        System.out.println("Enter number of graph Vertices & Edges: ");
        this.noOfVertices = ip.nextInt();
        int noOfEdges = ip.nextInt();
        a = new int [noOfVertices + 1][noOfVertices + 1];

        for(int i = 1; i <= noOfEdges; i++)
        {
            System.out.println("Enter start & end vertex of edge " + i + ": ");
            this.a[ip.nextInt()][ip.nextInt()] = 1;
        }
    }

    public void bfs(int startVertex)
    {
        boolean visited[] = new boolean[noOfVertices + 1];
        Queue <Integer> q = new ArrayDeque<>() ;

        visited[startVertex] = true;
        int v = startVertex ;

        System.out.println("\nNodes reachable from " + startVertex + ": ");
        while(true)
        {
            for (int i = 1; i <= noOfVertices; i++)
                if (v != i && a[v][i] == 1 && !visited[i])
                {
                    q.add(i);
                    visited[i] = true;
                }
            if (q.isEmpty())
                break;
            v = q.remove();
            System.out.print(v + " ");
        } /* end of while */
    } /* end dfs */

    public static void main(String[] args) {
        System.out.println("\nEnter start vertex :");
        int startVertex = new Scanner(System.in).nextInt();
        new BFS().bfs(startVertex);
    }
}
