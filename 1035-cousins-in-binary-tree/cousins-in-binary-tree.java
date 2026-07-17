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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode flagX=null;
        TreeNode flagY=null;
        Map<TreeNode,TreeNode> map=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        map.put(root,null);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.val==x){
                    flagX=node;
                }
                if(node.val==y){
                    flagY=node;
                }
                if(flagX!=null && flagY!=null){
                    if(map.get(flagX).val!=map.get(flagY).val){
                        return true;
                    }else{
                        return false;
                    }
                }
                if(node.left!=null){
                    queue.offer(node.left);
                    map.put(node.left,node);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    map.put(node.right,node);
                }
            }
            if(flagX!=null || flagY!=null){
                return false;
            }
        }
        return false;
    }
}