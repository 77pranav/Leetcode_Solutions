class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];
        int freshOranges=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                    visited[i][j]=true;
                }
                if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        int minutes=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean change=false;
            for(int i=0;i<size;i++){
                int[] pair=queue.poll();
                if(pair[0]>0 && !visited[pair[0]-1][pair[1]] && grid[pair[0]-1][pair[1]]==1){
                    queue.offer(new int[]{pair[0]-1,pair[1]});
                    visited[pair[0]-1][pair[1]]=true;
                    freshOranges--;
                    change=true;
                }
                if(pair[0]<n-1 && !visited[pair[0]+1][pair[1]] && grid[pair[0]+1][pair[1]]==1){
                    queue.offer(new int[]{pair[0]+1,pair[1]});
                    visited[pair[0]+1][pair[1]]=true;
                    freshOranges--;
                    change=true;
                }
                if(pair[1]>0 && !visited[pair[0]][pair[1]-1] && grid[pair[0]][pair[1]-1]==1){
                    queue.offer(new int[]{pair[0],pair[1]-1});
                    visited[pair[0]][pair[1]-1]=true;
                    freshOranges--;
                    change=true;
                }
                if(pair[1]<m-1 && !visited[pair[0]][pair[1]+1] && grid[pair[0]][pair[1]+1]==1){
                    queue.offer(new int[]{pair[0],pair[1]+1});
                    visited[pair[0]][pair[1]+1]=true;
                    freshOranges--;
                    change=true;
                }
            }
            if(change) minutes++;
        }
        return freshOranges!=0?-1:minutes;
    }
}