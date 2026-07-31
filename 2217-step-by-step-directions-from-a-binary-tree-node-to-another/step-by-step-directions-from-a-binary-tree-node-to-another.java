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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca=findLCA(root,startValue,destValue);
        StringBuilder answer=new StringBuilder();
        traverse(lca,answer,true,startValue);
        traverse(lca,answer,false,destValue);
        return answer.toString();
    }
    public TreeNode findLCA(TreeNode root,int start,int end){
        if(root==null) return null;
        if(root.val==start || root.val==end) return root;
        TreeNode left=findLCA(root.left,start,end);
        TreeNode right=findLCA(root.right,start,end);
        if(left!=null && right!=null){
            return root;
        }else if(left!=null){
            return left;
        }else if(right!=null){
            return right;
        }
        return null;
    }
    public boolean traverse(TreeNode root,StringBuilder answer,boolean flag,int ending){
        if(root==null){
            return false;
        }
        if(root.val==ending){
            return true;
        }
        String left=flag?"U":"L";
        String right=flag?"U":"R";
        answer.append(left);
        if(traverse(root.left,answer,flag,ending)){
            return true;
        }
        answer.deleteCharAt(answer.length()-1);
        answer.append(right);
        if(traverse(root.right,answer,flag,ending)){
            return true;
        }
        answer.deleteCharAt(answer.length()-1);
        return false;
    }
}