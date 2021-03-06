/*
* Filename    : BinomialCoef.java
* Problem Statement: 
* Computing Binomial Coefficient
* -------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.*;

public class BinomialCoef {  
    // Returns value of Binomial Coefficient C(n, k)
    static int binomialCoeff(int n, int k)
    { 
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;
 
        return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
    }
 
    public static void main(String[] args)
    {
        System.out.println("Enter the value of n & k: ");
        int n = new Scanner(System.in).nextInt();
        int k = new Scanner(System.in).nextInt();
        System.out.printf("C(%d, %d) = %d\n", n, k, binomialCoeff(n, k));
    }
}
