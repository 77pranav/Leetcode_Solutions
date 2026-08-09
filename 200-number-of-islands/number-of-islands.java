class Solution {
    public int numIslands(char[][] grid) {
       int rows=grid.length;
       int cols=grid[0].length;
       Stack<int[]> stack=new Stack<>();
       boolean[][] visited=new boolean[rows][cols];
       int islands=0;
       for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(visited[i][j] || grid[i][j]=='0'){
                visited[i][j]=true;
                continue;
            }
            stack.push(new int[]{i,j});
            while(!stack.isEmpty()){
                int[] ind=stack.pop();
                int row=ind[0];
                int col=ind[1];
                int[][] directions={{0,-1},{-1,0},{0,1},{1,0}};
                for(int k=0;k<directions.length;k++){
                    int new_row=row+directions[k][0];
                    int new_col=col+directions[k][1];
                    if(new_row >= 0 && new_row < rows && new_col>=0 && new_col < cols ){ 
                        if(grid[new_row][new_col] == '1' && !visited[new_row][new_col]){
                            stack.push(new int[]{new_row,new_col});
                        }
                        visited[new_row][new_col]=true;
                    }

                }
            }
            islands++;
        }
       }
       return islands;
    }
}