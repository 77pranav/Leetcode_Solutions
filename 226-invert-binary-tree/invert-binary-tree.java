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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        helper(root);
        return root;
    }
    public void helper(TreeNode root){
        if(root.left==null && root.right==null) return;
        if(root.left==null){
            root.left=root.right;
            root.right=null;
            helper(root.left);
            return;
        }
        if(root.right==null){
            root.right=root.left;
            root.left=null;
            helper(root.right);
            return;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        helper(root.left);
        helper(root.right);
    }
}