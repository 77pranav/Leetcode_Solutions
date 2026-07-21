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
    public void flatten(TreeNode root) {
        root=helper(root);
    }
    public TreeNode helper(TreeNode root){
        if(root==null) return null;
        TreeNode leftNode=helper(root.left);
        TreeNode rightNode=helper(root.right);
        TreeNode temp=root.right;
        if(leftNode!=null){
            root.right=leftNode;
            while(leftNode.right!=null){
                leftNode=leftNode.right;
            }
            leftNode.right=rightNode;
            root.left=null;
        }
        return root;
    }
}