/*
* FILENAME    : KnapsackMain.java
* Problem Statement:
* Knapsack problem solution using
*    (a) Dynamic Programming method (b) Memory Function.
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.Scanner;

public class KnapsackMain {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);

        //Read weights, values and knapsack capacity
        System.out.print("Enter the number of items in the knapsack: ");
        int noOfItems = ip.nextInt();

        int weight[] = new int[noOfItems + 1];
        int value[] = new int[noOfItems + 1];
        System.out.println("Enter the weight & value of " + noOfItems + " items");
        for(int i = 1; i <= noOfItems; i++)
        {
            System.out.print("   Item " + i + ": ");
            weight[i]  = ip.nextInt();
            value[i] = ip.nextInt();
        }

        System.out.print("Enter the Knapsack capacity: ");
        int capacity = ip.nextInt();

        System.out.println("\nOptimal Knapsack value using Dynamic Approach: " +
                new Knapsack(noOfItems, weight, value, capacity).computeDynamicSolution());

        System.out.println("Optimal Knapsack value using Memory Function: " +
                new Knapsack(noOfItems, weight, value, capacity).computeMemorySolution());
    }
}
