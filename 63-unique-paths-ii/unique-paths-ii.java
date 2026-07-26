class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length-1;
        int n=obstacleGrid[0].length-1;
        // return recursion(m,n,obstacleGrid);
        // return recursionMemo(m,n,obstacleGrid,new Integer[m+1][n+1]);
        // return tabulation(m,n,obstacleGrid);
        return spaceOptimized(m,n,obstacleGrid);
    }
    public int spaceOptimized(int m,int n,int[][] obstacleGrid){
        int[] col=new int[n+1];
        for(int i=0;i<=n;i++){
            if(obstacleGrid[0][i]==0){
                col[i]=1;
            }else{
                break;
            }
        }
        int last=col[n];
        for(int i=1;i<=m;i++){
            int row=(obstacleGrid[i][0]==0) ? col[0] : 0;
            col[0]=row;
            last=row;
            for(int j=1;j<=n;j++){
                if(obstacleGrid[i][j]==0){
                    last=row+col[j];
                }else{
                    last=0;
                }
                col[j]=last;
                row=last;
            }
        }
        return last;
    }
}