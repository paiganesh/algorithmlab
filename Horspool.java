/*
* FILENAME    : Horspool.java
* Problem Statement:
* Horspool string matching algorithm
* ------------------------------------------------------------------------------
* AUTHOR      : GANESH PAI, Dept. of CS&E, NMAMIT, Nitte
* YEAR        : 2021
* E-mail      : ganesh.pai@nitte.edu.in
* ------------------------------------------------------------------------------
*/

import java.util.*;

public class Horspool {
    public static int table[] = new int[127];

    private void shifttable(String pattern) 
    {
        int m = pattern.length();
        char p[] = pattern.toCharArray();

        Arrays.fill(table, m);
        
        for (int i = 0; i < m - 1; i++) 
            table[p[i]] = m - 1 - i;
    }

    public int horspool(String source, String pattern) 
    {
        int m;
        char s[] = source.toCharArray();
        char p[] = pattern.toCharArray();
        m = pattern.length();

        shifttable(pattern);
        for (int i = m - 1; i < source.length();) 
        {
            int k = 0;
            while ( (k < m) && (p[m - 1 - k] == s[i - k]) ) 
                k++;
            if (k == m) 
                return i - m + 2;    //Return position
            else 
                i += table[s[i]];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print("Enter the source string: ");
        String source = new Scanner(System.in).nextLine();
        
        System.out.print("Enter a pattern string: ");
        String pattern = new Scanner(System.in).nextLine();

        Horspool h = new Horspool();

        int pos = h.horspool(source, pattern);

        if (pos == -1) 
            System.out.println("Pattern NOT found");
        else 
            System.out.println("Pattern found at Position: " + pos + "\n");
    }
}
