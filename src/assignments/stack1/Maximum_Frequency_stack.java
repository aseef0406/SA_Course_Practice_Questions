package assignments.stack1;
/*
 * Problem Description

You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1

2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.



Problem Constraints

1 <= N <= 100000

1 <= A[i][0] <= 2

0 <= A[i][1] <= 109



Input Format

The only argument given is the integer array A.


Output Format

Return the array of integers denoting answer to each operation.


Example Input

Input 1:

A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]

Input 2:

 A =  [   
        [1, 5]
        [2 0]
        [1 4]   ]



Example Output

Output 1:

 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]

Output 2:

 [-1, 5, -1]

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Maximum_Frequency_stack {
	public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        
        int n=A.size();
        HashMap<Integer,Stack<Integer>> smap = new HashMap<>();
        
        HashMap<Integer,Integer> fmap = new HashMap<>();
        int max_freq = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(A.get(i).get(0)==1){
                int val = A.get(i).get(1);
                int freq;
                if(fmap.containsKey(val)){
                    freq = fmap.get(val)+1;
                    fmap.put(val,freq);
                }
                else{
                    freq = 1;
                    fmap.put(val,freq);
                }
                if(smap.containsKey(freq)){
                    smap.get(freq).push(val);
                }
                else{
                    Stack<Integer> tst = new Stack<>();
                    tst.push(val);
                    smap.put(freq,tst);
                }
                if(max_freq<freq){
                    max_freq=freq;
                }
                ans.add(-1);
            }
            else{
                int top = smap.get(max_freq).pop();
                fmap.put(top,fmap.get(top)-1);
                if(smap.get(max_freq).isEmpty()){
                    smap.remove(max_freq);
                    max_freq-=1;
                }
                ans.add(top);
            }
        }
        return ans;
    }
}
