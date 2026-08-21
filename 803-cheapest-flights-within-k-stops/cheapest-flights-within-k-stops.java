class Tuple{
    int node;
    int distance;
    int stops;
    public Tuple(int node,int distance,int stops){
        this.node=node;
        this.distance=distance;
        this.stops=stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            int u=flight[0];
            int v=flight[1];
            int weight=flight[2];
            adj.get(u).add(new int[]{v,weight});
        }
        Queue<Tuple> pq=new LinkedList<>();
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.offer(new Tuple(src,0,0));
        dist[src]=0;
        while(!pq.isEmpty()){
            Tuple current=pq.poll();
            if(current.stops>k){
                continue;
            }
            for(int[] list:adj.get(current.node)){
                int neighbour=list[0];
                int weight=list[1];
                int new_distance=current.distance+weight;
                if(new_distance < dist[neighbour]){
                    pq.offer(new Tuple(neighbour,new_distance,current.stops+1));
                    dist[neighbour]=new_distance;
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];

    }
}