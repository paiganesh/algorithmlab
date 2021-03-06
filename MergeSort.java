/*
* FILENAME    : MergeSort.java
* DESCRIPTION : Implementation of MergeSort class
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

public class MergeSort {
    private int data[];

    public MergeSort(int[] data) {
        this.data = data.clone();
    }

    public int [] sort()
    {
        divide(0, data.length - 1);
        return this.data;
    }
    
    private void divide(int low, int high)
    {         
        if(low < high)
        {
            int mid = (low + high) / 2;
            divide(low, mid);
            divide(mid + 1, high);
            merge(low, mid, high);
        }    
    }
    
    private void merge(int low, int mid, int high)
    {
        int i, p, q, a[] = new int[high + 1];
        i = p = low;
        q = mid + 1;

        while(p <= mid && q <= high)
            a[i++] = (data[p] < data[q])? data[p++] : data[q++];

        while(p <= mid)          // copy whatever remains from low to mid
            a[i++] = data[p++];
        while(q <= high)         // copy whatever remains from (mid+1) to high
            a[i++] = data[q++];

        for(i = low; i <= high; i++)
            data[i] = a[i];
    }
}