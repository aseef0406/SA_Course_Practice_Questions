//Fibonacci Number
// 
//Problem Description
// 
//Given a positive integer A, write a program to find the Ath Fibonacci number.
// 
//In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
// 
//NOTE: 0th term is 0. 1th term is 1 and so on.

package assignments.dp1;

import java.lang.*;
import java.util.*;
 
public class fibonacci {
    public int Fib(int n){
        if(n<=2) return 1;
        else return Fib(n-1)+Fib(n-2);
    }
 
 
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        fibonacci main = new fibonacci();
 
 
        System.out.println(main.Fib(n));
 
    }
}
