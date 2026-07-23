class Solution {
    public int climbStairs(int n, int[] costs) {
        return recursionMemo(n,costs,new Integer[n+1]);
    }
    public int recursion(int n,int[] costs){
        if(n<1) return n;
        int cost1=Integer.MAX_VALUE;
        int cost2=Integer.MAX_VALUE;
        int cost3=Integer.MAX_VALUE;
        if(n>=1){
            int power=(int)Math.pow(n-(n-1),2);
            cost1=recursion(n-1,costs)+costs[n-1]+power;
        }
        if(n>=2){
            int power=(int)Math.pow(n-(n-2),2);
            cost2=recursion(n-2,costs)+costs[n-1]+power;
        }
        if(n>=3){
            int power=(int)Math.pow(n-(n-3),2);
            cost3=recursion(n-3,costs)+costs[n-1]+power;
        }
        return Math.min(cost1,Math.min(cost2,cost3));
    }
    public int recursionMemo(int n,int[] costs,Integer[] dp){
        if(n<1) return n;
        if(dp[n]!=null) return dp[n];
        int cost1=Integer.MAX_VALUE;
        int cost2=Integer.MAX_VALUE;
        int cost3=Integer.MAX_VALUE;
        if(n>=1){
            int power=(int)Math.pow(n-(n-1),2);
            cost1=recursionMemo(n-1,costs,dp)+costs[n-1]+power;
        }
        if(n>=2){
            int power=(int)Math.pow(n-(n-2),2);
            cost2=recursionMemo(n-2,costs,dp)+costs[n-1]+power;
        }
        if(n>=3){
            int power=(int)Math.pow(n-(n-3),2);
            cost3=recursionMemo(n-3,costs,dp)+costs[n-1]+power;
        }
        return dp[n]=Math.min(cost1,Math.min(cost2,cost3));
    }
}