class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] best_reach=new int[n+1];
        for(int i=0;i<=n;i++){
            int leftEnd=i-ranges[i];
            int rightEnd=i+ranges[i];
            if(leftEnd<0) leftEnd=0;
            if(rightEnd>n) rightEnd=n;
            int ind=leftEnd;
            best_reach[ind]=Math.max(best_reach[ind],rightEnd);
        }
        int currentEnd=0;
        int farthest=0;
        int taps=0;
        int i=0;
        while(i<=n){
            while(i<=currentEnd){
                farthest=Math.max(farthest,best_reach[i]);
                i++;
            }
            if(farthest==currentEnd){
                return -1;
            }
            currentEnd=farthest;
            taps++;
            if(currentEnd>=n){
                return taps;
            }
        }
        return taps;
    }
}