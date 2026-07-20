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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Map<Integer,int[]> map=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<Integer> indQueue=new LinkedList<>();
        int row=0;
        queue.offer(root);
        indQueue.offer(1);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                Integer index=indQueue.poll();
                if(!map.containsKey(row)){
                    map.put(row,new int[]{index,index});
                }else{
                    map.get(row)[1]=index;
                }
                if(node.left!=null){
                    queue.offer(node.left);
                    indQueue.offer(2*index);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    indQueue.offer(2*index+1);
                }
            }
            row++;
        }
        int ans=0;
        for(Integer key:map.keySet()){
            int[] bounds=map.get(key);
            ans=Math.max(ans,bounds[1]-bounds[0]+1);
        }
        return ans;
    }
}