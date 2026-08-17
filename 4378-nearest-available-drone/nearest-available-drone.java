class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int result=-1;
        int result_dist=0;
        for(int i=0 ; i<drones.length ; i++){
            int distance=Math.abs(target[0]-drones[i][0])+Math.abs(target[1]-drones[i][1]);
            if(distance<=drones[i][2] && (result==-1 || distance<result_dist)){
                result=i;
                result_dist=distance;
            }
        }
        return result;
    }
}