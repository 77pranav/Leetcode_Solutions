class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[] newCuts=new int[m+2];
        newCuts[0]=0;
        newCuts[m+1]=n;
        for(int i=0;i<m;i++){
            newCuts[i+1]=cuts[i];
        }
        Arrays.sort(newCuts);
        // return recursion(0,newCuts.length-1,newCuts);
        return recursionMemo(0,newCuts.length-1,newCuts,new Integer[newCuts.length][newCuts.length]);
    }
    public int recursion(int start,int end,int[] cuts){
        if(end-start <= 1){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=start+1;i<end;i++){
            int left=recursion(start,i,cuts);
            int right=recursion(i,end,cuts);
            ans=Math.min(ans,left+right+(cuts[end]-cuts[start]));
        }
        return ans;
    }
    public int recursionMemo(int start,int end,int[] cuts,Integer[][] dp){
        if(end-start <= 1){
            return 0;
        }
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=start+1;i<end;i++){
            int left=recursionMemo(start,i,cuts,dp);
            int right=recursionMemo(i,end,cuts,dp);
            ans=Math.min(ans,left+right+(cuts[end]-cuts[start]));
        }
        return dp[start][end]=ans;
    }
}