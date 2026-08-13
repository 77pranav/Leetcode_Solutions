class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] bound_nums=new int[n+2];
        int m=n+2;
        for(int i=0;i<m;i++){
            if(i==0 || i==m-1){
                bound_nums[i]=1;
            }else{
                bound_nums[i]=nums[i-1];
            }
        }
        // return recursion(bound_nums,1,n);
        return recursion_memo(bound_nums,1,n,new Integer[m][m]);
    }
    public int recursion(int[] nums,int i,int j){
        if(i>j) return 0;
        int ans=0;
        for(int k=i;k<=j;k++){
            int left=recursion(nums,i,k-1);
            int right=recursion(nums,k+1,j);
            int coins=nums[i-1]*nums[k]*nums[j+1];
            ans=Math.max(ans,left+right+coins);
        }
        return ans;
    }
    public int recursion_memo(int[] nums,int i,int j,Integer[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int ans=0;
        for(int k=i;k<=j;k++){
            int left=recursion_memo(nums,i,k-1,dp);
            int right=recursion_memo(nums,k+1,j,dp);
            int coins=nums[i-1]*nums[j+1]*nums[k];
            ans=Math.max(ans,left+right+coins);
        }
        return dp[i][j]=ans;
    }
}