class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length-1;
        int n=obstacleGrid[0].length-1;
        // return recursion(m,n,obstacleGrid);
        // return recursionMemo(m,n,obstacleGrid,new Integer[m+1][n+1]);
        return tabulation(m,n,obstacleGrid);
    }
    
    public int tabulation(int m,int n,int[][] obstacleGrid){
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            if(obstacleGrid[i][0]==0){
                dp[i][0]=1;
            }else{
                break;
            }
        }
        for(int j=0;j<=n;j++){
            if(obstacleGrid[0][j]==0){
                dp[0][j]=1;
            }else{
                break;
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}