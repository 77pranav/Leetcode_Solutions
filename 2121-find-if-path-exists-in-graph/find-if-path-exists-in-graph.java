class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n+1];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(source);
        visited[source]=true;
        while(!queue.isEmpty()){
            int node=queue.poll();
            if(node==destination){
                return true;
            }
            for(int element:adj.get(node)){
                if(!visited[element]){
                    queue.offer(element);
                    visited[element]=true;
                }
            }
        }
        return false;
    }
}

