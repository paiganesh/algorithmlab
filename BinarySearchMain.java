/*
* FILENAME    : BinarySearch.java
* Problem Statement: Implementation of Binary Search Algorithm
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.Scanner;

public class BinarySearchMain 
{
    public static void main(String[] args) 
    {
        Scanner ip = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int noOfElements = ip.nextInt();
        int a[] = new int[noOfElements];

        System.out.println("Enter " + noOfElements + " elements:");
        for(int i = 0; i < noOfElements; i++)
            a[i] = ip.nextInt();

        System.out.print("Enter the search element: ");
        int searchElement = ip.nextInt();

        int pos = new BinarySearch(a, noOfElements).search(searchElement);
        if (pos == -1)
            System.out.println("Element NOT found.");
        else
            System.out.println("Element found at position " + pos);
    }
}
