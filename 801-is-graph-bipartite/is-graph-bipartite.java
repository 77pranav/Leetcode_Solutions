class Solution {
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int[] color=new int[V];
        boolean[] visited=new boolean[V];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(visited[i]){
                continue;
            }
            queue.offer(i);
            visited[i]=true;
            color[i]=1;
            while(!queue.isEmpty()){
                int node=queue.poll();
                visited[node]=true;
                for(int neigh:graph[node]){
                    if(!visited[neigh]){
                        if(color[node]==color[neigh]){
                            return false;
                        }
                        color[neigh]=-color[node];
                        queue.offer(neigh);
                    }
                }
            } 
        }
        return true;
    }
}