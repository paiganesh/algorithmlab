/*
* Filename    : Dijkstras.java
* Problem Statement: 
* From a given vertex in a weighted connected graph, find shortest paths to 
* other vertices using Dijkstra's algorithm.
* -------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstras {

    private class Vertex
    {    
        int distance, parent;
    }

    private final int INFINITY = 99999;
    
    private int numberOfVertices, sourceNode, graph[][];
    private Vertex vertex[];
    
    private void init()
    {
        graph = new int [numberOfVertices + 1][numberOfVertices + 1];
        vertex = new Vertex[numberOfVertices + 1];
        
        for(int i = 1; i <= numberOfVertices; i++)            
        {
            Arrays.fill(graph[i], INFINITY);
            graph[i][i] = 0;
            vertex[i] = new Vertex();
            vertex[i].distance = INFINITY;
        }
    }

    public void readGraph()
    {
        int v1, v2, edge = 0;
        Scanner ip = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices & edges: ");
        numberOfVertices = ip.nextInt();
        int numberOfEdges = ip.nextInt();
        
        init();
        while(edge++ != numberOfEdges)
        {
            System.out.print("Enter start & end vertex of edge " + edge + ": ");
            v1 = ip.nextInt();
            v2 = ip.nextInt();
            System.out.print("Enter the weight of the edge [" + v1 + "--->" + v2 + "]: ");
            graph[v1][v2] = graph[v2][v1] = ip.nextInt();
        }
    }
    
    public void computeShortestPath(int sourceNode)
    {
        final int TENTATIVE = 0, PERMANENT = 1;
        int nearestNode = sourceNode, currentNode = sourceNode;
        int state[] = new int[numberOfVertices + 1];
        this.sourceNode = sourceNode;
        Arrays.fill(state, TENTATIVE);
        state[sourceNode] = PERMANENT;
        vertex[sourceNode].distance = 0;
        
        for(int node = 1; node < numberOfVertices; node++)
        {
            for(int i = 1, min = INFINITY; i <= numberOfVertices; i++)   //Node relaxation for all adjacent nodes
            {                
                if( (graph[currentNode][i] != INFINITY) && (state[i] == TENTATIVE) )
                {
                    int newDistance = vertex[currentNode].distance + graph[currentNode][i];
                    if(newDistance < vertex[i].distance)
                    {
                        vertex[i].distance = newDistance;
                        vertex[i].parent = currentNode;
                    }
                }    
                if((state[i] == TENTATIVE) && (vertex[i].distance < min))
                {
                    min = vertex[i].distance;
                    nearestNode = i;
                }
            }
            state[nearestNode] = PERMANENT;
            currentNode = nearestNode;
        }
    }
    
    public void printPaths()
    {
        for(int targetNode = 1; targetNode <= numberOfVertices; targetNode++)
        {
            if(sourceNode == targetNode)    
                continue;
            System.out.print(sourceNode + " to " + targetNode + ": ");  
            pathWalk(targetNode);
            System.out.println(":" + vertex[targetNode].distance);
        }
    }

    private void pathWalk(int node)
    {
        if(node == 0)
            return;
        pathWalk(vertex[node].parent);
        System.out.print(node + " ");
    }
    
    public static void main(String[] args) {
        Dijkstras dj = new Dijkstras();
        
        dj.readGraph();        
        System.out.print("\nEnter a source vertex: ");
        int sourceVertex = new Scanner(System.in).nextInt();
        
        dj.computeShortestPath(sourceVertex);
        
        System.out.println("\nShortest path from " + sourceVertex + " to all other vertices :");
        dj.printPaths();
    }
}