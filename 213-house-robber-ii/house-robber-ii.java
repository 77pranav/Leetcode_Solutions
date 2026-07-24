class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        // return Math.max(recursion(nums,n,2),recursion(nums,n-1,1));
        return Math.max(recursionMemo(nums,n,2,new Integer[n+1]),recursionMemo(nums,n-1,1,new Integer[n+1]));
    }
    public int recursion(int[] nums,int n,int end){
        if(n<end){
            return 0;
        }
        int take=nums[n-1]+recursion(nums,n-2,end);
        int not_take=recursion(nums,n-1,end);
        return Math.max(take,not_take);
    }
    public int recursionMemo(int[] nums,int n,int end,Integer[] dp){
        if(n<end) return 0;
        if(dp[n]!=null) return dp[n];
        int take=nums[n-1]+recursionMemo(nums,n-2,end,dp);
        int not_take=recursionMemo(nums,n-1,end,dp);
        return dp[n]=Math.max(take,not_take);
    }
    // public int tabulation(int[] nums,int n,int start){
    //     Integer[] dp=new Integer[n];
    //     dp[0]=0;

    // }
}