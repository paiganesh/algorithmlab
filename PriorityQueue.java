/*
* FILENAME    : PriorityQueue.java
* Problem Statement:
* Implementation of Priority Queue using Heap
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.Scanner;
public class PriorityQueue {

    int heap[] = new int[50], noOfElements=0;

    public void insert(int elem)
    {
        int i;
        heap[++noOfElements] = elem;
        for(i = noOfElements; (i > 1) && (heap[i/2] < elem); i /= 2)
                heap[i] = heap[i/2];
        heap[i] = elem;
    }

    public Integer remove()
    {
        if (noOfElements == 0)
            return null;

        int removedElem = heap[1];
        heap[1] = heap[noOfElements--];
        int j, elem = heap[1];

        for(j = 2; j <= noOfElements; j = 2 * j)
        {
                if((j < noOfElements) && (heap[j] < heap[j+1]))
                        j++;
                if(elem >= heap[j])
                        break;
                heap[j / 2] = heap[j];
        }
        heap[j / 2] = elem;

        return removedElem;
    }

    public static void main(String[] args) {

        Scanner ip = new Scanner(System.in);
        PriorityQueue hs = new PriorityQueue();

        while(true)
        {
            System.out.println("Menu:\n1. Insert an element\n2.Remove an element\n3. Exit\nEnter your choice:");
            switch(ip.nextInt())
            {
                case 1:
                    System.out.println("Enter a number: ");
                    hs.insert(ip.nextInt());
                    break;
                case 2:
                    Integer elem = hs.remove();
                    if (elem == null)
                        System.out.println("Empty Queue");
                    else
                        System.out.println("Removed number is: " + elem);
                    break;
                default:System.exit(0);
            }
        }
    }
}
