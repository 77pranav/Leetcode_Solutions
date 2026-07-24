class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        // return Math.max(recursion(nums,n,2),recursion(nums,n-1,1));
        // return Math.max(recursionMemo(nums,n,2,new Integer[n+1]),recursionMemo(nums,n-1,1,new Integer[n+1]));
        // return Math.max(tabulation(nums,0,n-2),tabulation(nums,1,n-1));
        return Math.max(spaceOptimized(nums,0,n-2),spaceOptimized(nums,1,n-1));
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
    public int tabulation(int[] nums,int start,int end){
        int n=nums.length;
        Integer[] dp=new Integer[n];
        dp[0]=0;
        dp[1]=nums[start];
        int k=2;
        for(int i=start+1;i<=end;i++){
            dp[k]=Math.max(dp[k-1],dp[k-2]+nums[i]);
            k++;
        }
        return dp[n-1];
    }
    public int spaceOptimized(int[] nums,int start,int end){
        int prev1=nums[start];
        int prev2=0;
        int last=prev1;
        for(int i=start+1;i<=end;i++){
            last=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=last;
        }
        return last;
    }
}