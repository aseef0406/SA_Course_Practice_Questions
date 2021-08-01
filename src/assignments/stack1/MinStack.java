package assignments.stack1;

import java.util.ArrayList;

//Problem Description
//
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//    push(x) -- Push element x onto stack.
//    pop() -- Removes the element on top of the stack.
//    top() -- Get the top element.
//    getMin() -- Retrieve the minimum element in the stack.
//
//NOTE:
//
//    All the operations have to be constant time operations.
//    getMin() should return -1 if the stack is empty.
//    pop() should return nothing if the stack is empty.
//    top() should return -1 if the stack is empty.
//
//
//
//Problem Constraints
//
//1 <= Number of Function calls <= 107


public class MinStack {
	
	private final ArrayList<Integer> al = new ArrayList<>();
    private int top=-1;
    private final ArrayList<Integer> ms = new ArrayList<>();
    
    public void push(int x) {
        // System.out.println(x+" "+top);
        int n=al.size();
        if(isEmpty()){
            if(n>0){
                ms.set(top+1,x);
                al.set(top+1,x);
            }
            else{
                ms.add(x);
                al.add(x);
            }
        }
        else if(x<=ms.get(top)){
            if(top<(n-1)){
                ms.set(top+1,x);
                al.set(top+1,x);
            }
            else{
                al.add(x);
                ms.add(x);
            }
        }
        else{
            if(top<(n-1)){
                al.set(top+1,x);
                ms.set(top+1,ms.get(top));
            }
            else{
                al.add(x);
                ms.add(ms.get(top));
            }
            
        }
        top++;
    }

    public void pop() {
        if(top>=0)
            top--;
    }

    public int top() {
        if(isEmpty())
            return -1;
        // System.out.println("\n"+al+" top : "+top);
        return al.get(top);
    }

    public int getMin() {
        if(isEmpty())
            return -1;
        return ms.get(top);
    }
    
    public boolean isEmpty(){
        return top<=-1?true:false;
    }

}
