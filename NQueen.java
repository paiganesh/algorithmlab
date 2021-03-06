/*
* FILENAME    : NQueen.java
* Problem Statement: Implementation of NQueen's problem
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.Scanner;

public class NQueen {
    private int x[], count = 0, noQ;

    private void queen(int k, int n)
    {
        for(int i = 1; i <= n; i++)
            if(place(k, i))
            {
                x[k] = i;
                if(k == n)
                    printBoard(++count);   // Queen Placed in All rows --> Solution
                else
                    queen(k + 1, n);
            }
    }

    private boolean place(int k, int i)
    {
        for(int m = 1; m <= k-1; m++)
            if ( (x[m] == i) || (Math.abs(k - m) == Math.abs(i - x[m])) )//Same column OR diagonal
                return false;    // Not Placable
        return true;    // Placable
    }

    private void printBoard(int cnt)
    {
        System.out.println("\n Solution " + cnt + "\n");
        for(int p = 1; p <= noQ; p++)
        {
            for(int q = 1; q <= noQ; q++)
                System.out.print( (x[p] == q)? "Q  " : "-  ");
            System.out.println();
        }
    }

    public NQueen(int noOfQueens)
    {
        noQ = noOfQueens;
        x = new int[noQ + 1];
    }

    public void solve()
    {
        queen(1, noQ);
        if (count == 0)
            System.out.println("No Solution for " + noQ + "-queens.");
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of Queens:");
        int n = new Scanner(System.in).nextInt();
        new NQueen(n).solve();
    }
}
