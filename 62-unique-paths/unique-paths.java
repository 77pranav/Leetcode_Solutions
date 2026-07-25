class Solution {
    public int uniquePaths(int m, int n) {
    //    return recursionMemo(m,n,new Integer[m+1][n+1]);
        // return tabulation(m,n); 
        return spaceOptimized(m,n);
    }
    public int recursion(int m,int n){
        if(m<=1 && n<=1) return 1;
        if(m<=0 || n<=0) return 0;
        int down=recursion(m-1,n);
        int right=recursion(m,n-1);
        return down+right;
    }
    public int recursionMemo(int m,int n,Integer dp[][]){
        if(m<=1 && n<=1) return 1;
        if(m<=0 || n<=0) return 0;
        if(dp[m][n] != null) return dp[m][n];
        int down=recursionMemo(m-1,n,dp);
        int right=recursionMemo(m,n-1,dp);
        return dp[m][n]=down+right;
    }
    public int tabulation(int m,int n){
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,1);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public int spaceOptimized(int m,int n){
        int last=1;
        int[] col=new int[n];
        Arrays.fill(col,1);
        for(int i=1;i<m;i++){
            int[] row=new int[m];
            Arrays.fill(row,1);
            for(int j=1;j<n;j++){
                last=row[i]+col[j];
                col[j]=last;
                row[i]=last;
            }
        }
        return last;
    }
}