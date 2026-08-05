class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int i=0;
        int max_len=0;
        int n=s.length();
        for(int j=0;j<n;j++){
            char curr=s.charAt(j);
            if(!map.containsKey(curr) || map.get(curr)<i){
                max_len=Math.max(j-i+1,max_len);
            }else{
                i=map.get(curr)+1;
            }
            map.put(curr,j);
        }
        return max_len;
    }
}