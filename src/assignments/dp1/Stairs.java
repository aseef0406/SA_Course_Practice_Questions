package assignments.dp1;

//Stairs
//
//Problem Description
//
//You are climbing a stair case and it takes A steps to reach to the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
public class Stairs {
    
    
    public int climb(int n,int[] dp){
        if(n==1) return 1;
        if(n==2) return 2;
        if(dp[n-1]!=-1){
            return dp[n-1];
        }
        
        int ans = climb(n-1,dp) + climb(n-2,dp);
        dp[n-1]=ans;
        return ans;
        
    }
    
    public int climbStairs(int A) {
        
        int dp[] = new int[A];
        for(int i=0;i<A;i++){
            dp[i]=-1;
        }
        // for(int i=0;i<A;i++){
        //     System.out.print(dp[i]+" ");
        // }
        
        return climb(A,dp);
        
    }
}