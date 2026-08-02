class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        // return recursionMemo(coins,amount,new Integer[amount+1]);
        return tabulation(coins,amount);
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
    public int tabulation(int[] coins,int amount){
        if(amount==0) return 0;
        int n=coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                int amt=-1;
                if(coins[j]==i){
                    amt=1;
                }else if(coins[j]<i){
                    if(dp[i-coins[j]]!=Integer.MAX_VALUE){
                        amt=1+dp[i-coins[j]];
                    }
                }
                if(amt!=-1){
                    dp[i]=Math.min(dp[i],amt);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}