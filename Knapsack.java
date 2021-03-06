/*
* FILENAME    : Knapsack.java
* DESCRIPTION : Implementation of Knapsack using Dynamic approach & Memory Function.
*/

public class Knapsack {
    private final int noOfItems, capacity, weight[], value[];
    private int V[][];

    public Knapsack(int noOfItems, int weight[], int value[], int capacity) {
        this.weight = weight;
        this.value  = value;
        this.capacity = capacity;
        this.noOfItems = noOfItems;
    }

    public int computeDynamicSolution()
    {
        int v[][] = new int[noOfItems + 1][capacity + 1];

        for(int i = 1; i <= noOfItems; i++)
        {
            for(int j = 1; j <= capacity; j++)
                if(j < weight[i])
                    v[i][j] = v[i - 1][j];
                else
                    v[i][j] = Math.max(v[i - 1][j], value[i] + v[i - 1][j - weight[i]]);
        }
        return v[noOfItems][capacity];
    }

    public int computeMemorySolution()
    {
        this.V = new int[noOfItems + 1][capacity + 1];
        for(int i = 1; i <= noOfItems; i++)
            for(int j = 1; j <= capacity; j++)
                V[i][j] = -1;

        return MFKnapsack(noOfItems, capacity);
    }

    private int MFKnapsack(int i, int C) // n, C represent the sub problem
    {
        if (V[i][C] < 0 )
            if (C < weight[i])
                V[i][C] = MFKnapsack(i-1, C);
            else
                V[i][C] = Math.max(MFKnapsack(i-1, C), value[i] + MFKnapsack(i-1, C-weight[i]));
        return V[i][C];
    }
}
