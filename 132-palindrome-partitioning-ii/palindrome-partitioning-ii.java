class Solution {
    public int minCut(String s) {
        int n=s.length();
        boolean[][] pal=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=i;j--){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=2 || pal[i+1][j-1]){
                        pal[i][j]=true;
                    }
                }
            }
        }
        // return recursion(s,0,n-1,pal);
        return recursionMemo(s,0,new Integer[n],pal);
    }
    public int recursion(String s,int i,int j,boolean[][] pal){
        if(i>=j) return 0;
        if(pal[i][j]) return 0;
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            ans=Math.min(ans,1+recursion(s,i,k,pal)+recursion(s,k+1,j,pal));
        }
        return ans;
    }
    // public int recursionMemo(String s,int i,int j,Integer[][] dp,boolean[][] pal){
    //     if(i>=j) return 0;
    //     if(dp[i][j]!=null) return dp[i][j];
    //     if(pal[i][j]) return 0;
    //     int ans=Integer.MAX_VALUE;
    //     for(int k=i;k<j;k++){
    //         ans=Math.min(ans,1+recursionMemo(s,i,k,dp,pal)+recursionMemo(s,k+1,j,dp,pal));
    //     }
    //     return dp[i][j]=ans;
    // }
    public int recursionMemo(String s,int start,Integer[] dp,boolean[][] pal){
        int n=s.length();
        if(start>=n || pal[start][n-1]) return 0;
        if(dp[start]!=null) return dp[start];
        int ans=Integer.MAX_VALUE;
        for(int k=start;k<n-1;k++){
            if(pal[start][k]){
                ans=Math.min(ans,1+recursionMemo(s,k+1,dp,pal));
            }
        }
        return dp[start]=ans;
    }
}