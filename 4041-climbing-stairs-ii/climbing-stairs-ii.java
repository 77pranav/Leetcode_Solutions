class Solution {
    public int climbStairs(int n, int[] costs) {
        return spaceOptimized(n,costs);
    }
    public int spaceOptimized(int n,int[] costs){
        int third=0;
        int second=Integer.MAX_VALUE;
        int first=second;
        int answer=-1;
        for(int i=1;i<=n;i++){
            if(i==1){
                answer=Math.min(third+costs[i-1]+1,Math.min(second,first));
            }
            if(i==2){
                answer=Math.min(third+costs[i-1]+1,Math.min(second+costs[i-1]+4,first));
            }
            if(i>=3){
                answer=Math.min(third+costs[i-1]+1,Math.min(second+costs[i-1]+4,first+costs[i-1]+9));
            }
            first=second;
            second=third;
            third=answer;
        }
        return answer;
    }
}