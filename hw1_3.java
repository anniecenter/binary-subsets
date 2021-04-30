/*
* Title: hw1_3.java
* Abstract: This program reads a number of elements in a 
            set and then reads the elements of the set. 
            It then displays all possible binary numbers 
            and corresponding subsets one by one
* Author: Annie Center
* ID: 8392
* Date: 03/09/2021
*/

import java.util.Scanner;

public class hw1_3 {
    public static String toBinary(int x, int len) {
        if (len > 0) {
            return String.format("%" + len + "s", Integer.toBinaryString(x)).replaceAll(" ", "0");
        }
        return null;
    }
    
    public static String getSubset(String bin, String[] set) {
        String subset = "";
        
        if(bin.equals(toBinary(0, set.length))) {
            subset = "EMPTY";
        }
        else {
            for(int i = 0; i < bin.length(); i++) {
                if(bin.charAt(i) == '1') {
                    subset += set[i] + " ";
                }
            }
        }
        return subset;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String set[] = new String[n];
        
        if(n == 0) {
            System.out.println("0:EMPTY");
            return;
        }
        
        for(int i = 0; i < n; i++) {
            set[i] = input.next();
        }
        
        for(int i = 0; i < Math.pow(2, n); i++) {
            String bin = toBinary(i, n);
            System.out.println(bin + ":" + getSubset(bin, set));
        }
    }
}
