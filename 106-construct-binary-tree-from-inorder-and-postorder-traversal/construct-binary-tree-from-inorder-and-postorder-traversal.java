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
    int postIndex=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return createTree(inorder,postorder,0,inorder.length-1,map);
    }
    public TreeNode createTree(int[] inorder,int[] postorder,int left,int right,Map<Integer,Integer> map){
        if(left>right) return null;
        TreeNode root=new TreeNode(postorder[postIndex--]);
        int i=map.get(root.val);
        root.right=createTree(inorder,postorder,i+1,right,map);
        root.left=createTree(inorder,postorder,left,i-1,map);
        return root;
    }
}