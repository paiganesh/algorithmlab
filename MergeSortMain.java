/*
* FILENAME    : MergeSortMain.java
* Problem Statement:
* To sort a given set of n integer elements using Merge Sort method.
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortMain {
    public static void main(String[] args) {

        Scanner ip = new Scanner(System.in);

        //Read input
        System.out.print("Enter the number of elements: ");
        int noOfElements = ip.nextInt();

        System.out.print("Enter " + noOfElements + " integer elements: ");
        int data[] = new int[noOfElements];
        for(int i=0; i < noOfElements; i++)
            data[i] = ip.nextInt();

        //Class instance Creation and call for computation
        MergeSort ms = new MergeSort(data);
        int sorteddata [] = ms.sort();

        //Print Results
        System.out.println("Unsorted numbers: " + Arrays.toString(data));
        System.out.println("Sorted numbers: " + Arrays.toString(sorteddata));
    }
}
