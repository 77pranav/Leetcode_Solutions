class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int current=0;
        int result=0;
        for(int i=0;i<requests.length;i++){
            result += Math.abs(current-requests[i]);
            current=requests[i];
        }
        return result;
    }
}