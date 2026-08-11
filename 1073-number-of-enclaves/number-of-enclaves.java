class Solution {
    boolean edgeTouch;
    public int numEnclaves(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visited=new boolean[rows][cols];
        int ans=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    edgeTouch=false;
                    int count= dfs(rows,cols,i,j,grid,visited);
                    if(!edgeTouch){
                        ans += count;
                    }
                }
            }
        }
        return ans;
    }
    public int dfs(int rows,int cols,int i,int j,int[][] grid,boolean[][] visited){
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || grid[i][j]==0){
            return 0;
        }
        if(i==0 || i==rows-1 || j==0 || j==cols-1){
            edgeTouch=true;
        }
        visited[i][j]=true;
        int count = 1;
        int left=dfs(rows,cols,i,j-1,grid,visited);
        int up=dfs(rows,cols,i-1,j,grid,visited);
        int right=dfs(rows,cols,i,j+1,grid,visited);
        int down=dfs(rows,cols,i+1,j,grid,visited);
        if(edgeTouch) return 0;
        return count+left+up+right+down;
    }
}