// class Tuple{
//     int node;
//     int distance;
//     int stops;
//     public Tuple(int node,int distance,int stops){
//         this.node=node;
//         this.distance=distance;
//         this.stops=stops;
//     }
// }
class Tuple{
    int stops;
    int node;
    int price;
    public Tuple(int stops,int node,int price){
        this.stops=stops;
        this.node=node;
        this.price=price;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int flight[]:flights){
            int u=flight[0];
            int v=flight[1];
            int price=flight[2];
            adj.get(u).add(new int[]{v,price});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Tuple> queue=new LinkedList<>();
        queue.add(new Tuple(0,src,0));
        dist[src]=0;
        while(!queue.isEmpty()){
            Tuple cur=queue.poll();
            int stops=cur.stops;
            int node=cur.node;
            int cost=cur.price;
            if(stops>k) continue;
            for(int neigh[]:adj.get(node)){
                int adjNode=neigh[0];
                int price=neigh[1];
                if(cost+price<dist[adjNode]){
                    dist[adjNode]=cost+price;
                    queue.add(new Tuple(stops+1,adjNode,dist[adjNode]));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];

    }
}