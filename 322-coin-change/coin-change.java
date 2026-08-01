class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        return recursionMemo(coins,amount,new Integer[amount+1]);
    }
    public int recursion(int[] coins, int amount){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int count=0;
            int res=recursion(coins,amount-coins[i]);
            if(res==-1){
                continue;
            }else{
                count=1+res;
            }
            ans=Math.min(ans,count);
        }
        return ans==Integer.MAX_VALUE ? -1:ans;
    }
    public int recursionMemo(int[] coins,int amount,Integer[] dp){
        if(amount==0) return 0;
        if(amount<0) return -1;
        if(dp[amount]!=null) return dp[amount];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int count=0;
            int res=recursionMemo(coins,amount-coins[i],dp);
            if(res!=-1){
                count = 1+res;
            }else{
                continue;
            }
            ans=Math.min(ans,count);
        }
        return dp[amount]=(ans==Integer.MAX_VALUE)?-1:ans;
    }
}