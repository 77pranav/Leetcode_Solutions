class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int[] prefix_sum=new int[n];
        int max_len=0;
        if(nums[0]==0) prefix_sum[0]=-1;
        else prefix_sum[0]=1;
        for(int i=1;i<n;i++){
            if(nums[i]==1){
                prefix_sum[i] = prefix_sum[i-1] + 1;
            }else{
                prefix_sum[i] = prefix_sum[i-1] - 1;
            }
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(prefix_sum[i]) && prefix_sum[i]!=0){
                int curr_len=i-map.get(prefix_sum[i]);
                max_len=Math.max(max_len,curr_len);
            }else{
                map.put(prefix_sum[i],i);
            }
        }
        if(map.containsKey(0)){
            max_len=Math.max(max_len,map.get(0)+1);
        }
        return max_len;
    }
}