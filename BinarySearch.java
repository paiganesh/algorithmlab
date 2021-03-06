/*
* FILENAME    : BinarySearch.java
* Problem Statement: Implementation of Binary Search Class
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

public class BinarySearch 
{
    private final int data[], noOfElements;

    public BinarySearch(int[] data, int noOfElements) 
    {
        this.data = data;
        this.noOfElements = noOfElements;
    }

    public int search(int elem)
    {
        return binsearch(0, noOfElements - 1, elem);
    }

    private int binsearch(int low, int high, int elem)
    {
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(data[mid] == elem)
                return mid + 1;
            else if (data[mid] < elem)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
