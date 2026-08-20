class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1;
        int j=1;
        int n=nums.length;
        while(j<n && i<n){
            if(nums[i]!=nums[i-1]){
                nums[j]=nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}