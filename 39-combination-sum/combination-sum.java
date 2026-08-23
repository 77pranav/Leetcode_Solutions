class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,0,list,result);
        return result;
    }
    public void helper(int[] candidates,int target,int sum,int start,List<Integer> list,List<List<Integer>> result){
        if(sum==target){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(sum+candidates[i]>target){
                break;
            }

            list.add(candidates[i]);
            sum += candidates[i];
            helper(candidates,target,sum,i,list,result);
            list.remove(list.size()-1);
            sum -= candidates[i];
        }
    }
}