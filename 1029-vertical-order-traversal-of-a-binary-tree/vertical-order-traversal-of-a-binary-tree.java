/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> comp=new TreeMap<>();
        Integer row=0;
        Integer col=0;
        dfs(comp,root,row,col);
        for(Integer set1:comp.keySet()){
            List<Integer> list=new ArrayList<>();
            for(Integer set2:comp.get(set1).keySet()){
                PriorityQueue<Integer> pq=comp.get(set1).get(set2);
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            result.add(list);
        }
        return result;
    }
    public void dfs(Map<Integer,Map<Integer,PriorityQueue<Integer>>> comp,TreeNode root,Integer row,Integer col){
       if(root==null){
            return;
       }
       if(!comp.containsKey(col)){
            Map<Integer,PriorityQueue<Integer>> temp=new TreeMap<>();
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            pq.offer(root.val);
            temp.put(row,pq);
            comp.put(col,temp);
       }else{
            if(!comp.get(col).containsKey(row)){
                PriorityQueue<Integer> pq=new PriorityQueue<>();
                pq.offer(root.val);
                comp.get(col).put(row,pq);
            }else{
                comp.get(col).get(row).offer(root.val);
            }
       }
       dfs(comp,root.left,row+1,col-1);
       dfs(comp,root.right,row+1,col+1);
    }
}