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
    public int goodNodes(TreeNode root) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        pq.offer(Integer.MIN_VALUE);
        return helper(root,pq);
    }
    public int helper(TreeNode root,PriorityQueue<Integer> pq){
        if(root==null) return 0;
        int flag=0;
        if(root.val>=pq.peek()){
            pq.offer(root.val);
            flag=1;
        }
        int left=helper(root.left,pq);
        int right=helper(root.right,pq);
        if(root.val==pq.peek()) pq.poll();
        return flag+left+right;
    }
}