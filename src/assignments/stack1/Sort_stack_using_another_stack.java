package assignments.stack1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
/*
 * Sort stack using another stack

Problem Description

Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints

1 <= |A| <= 5000

0 <= A[i] <= 1000000000 

 */
public class Sort_stack_using_another_stack {

	public ArrayList<Integer> solve(ArrayList<Integer> A) {
        
        int n=A.size();
        int top = n-1;
        Stack<Integer> st = new Stack<>();
        
        int cele = A.remove(top--);
        
        if(st.empty()){
            st.push(cele);
        }
        // System.out.println(st);
        // cele = A.remove(top--);
        while(top>-1)
        {   
            cele = A.remove(top--);
            // System.out.println(cele+" "+st);
            while(!st.empty() && !(cele>=st.peek())){
                // System.out.println("ok");
                // System.out.println(cele+" "+st);
                A.add(st.pop());
                // System.out.println(cele+" "+st);
                top++;
            }
            // System.out.println(" after poping from stack to arraylist"+st);
            st.push(cele);
            // System.out.println(" Inserting the cele in stack "+st);
            while(top>-1 && A.get(top)>st.peek()){
                st.push(A.remove(top--));
            }
            // System.out.println("end "+st);
        }
        // System.out.println(st);
        while(!st.empty()){
            A.add(st.pop());
        }
        Collections.reverse(A);
        return A;
                
    }
}
