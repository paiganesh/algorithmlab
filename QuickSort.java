/*
* FILENAME    : QuickSort.java
* DESCRIPTION : Implementation of QuickSort class
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

public class QuickSort {
    private int data[];

    public QuickSort(int[] data) {
        this.data = data.clone();
    }

    public int [] sort()
    {
        quicksort(0, data.length - 1);
        return this.data;
    }

    private void quicksort(int low, int high)
    {
        if(low < high)
        {
            int pivot = partition(low, high);
            quicksort(low, pivot - 1);
            quicksort(pivot + 1, high);
        }
    }

    private int partition(int low, int high)
    {
        int pivot = data[low], i = low + 1, j = high, tmp;

        while(i <= j)
        {
            while(i <= high && data[i] <= pivot)
                i++;
            while(data[j] > pivot)
                j--;

            if(i < j)
            {
                tmp     = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }
        }
        tmp       = data[low];
        data[low] = data[j];
        data[j]   = tmp;

        return j;
    }
}
