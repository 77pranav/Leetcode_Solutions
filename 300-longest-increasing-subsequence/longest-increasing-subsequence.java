class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        // return helper(nums,nums.length-1,Integer.MAX_VALUE);
        Integer[][] dp=new Integer[n][n+1];
        // for(int i=0;i<n;i++){
        //     dp[i][n]=Integer.MAX_VALUE;
        // }
        return helperMemo(nums,n-1,n,dp);
    }
    public int helper(int[] nums,int n,int previous){
        if(n<0) return 0;
        int take=0;
        if(nums[n]<previous){
            take=1+helper(nums,n-1,nums[n]);
        }
        int not_take=helper(nums,n-1,previous);
        return Math.max(take,not_take);
    }
    public int helperMemo(int[] nums,int n,int prevIndex,Integer[][] dp){
        if(n<0) return 0;
        if(dp[n][prevIndex]!=null) return dp[n][prevIndex];
        int take=0;
        if(prevIndex==nums.length || nums[n]<nums[prevIndex]){
            take=1+helperMemo(nums,n-1,n,dp);
        }
        int not_take=helperMemo(nums,n-1,prevIndex,dp);
        return dp[n][prevIndex]=Math.max(take,not_take);
    }
}