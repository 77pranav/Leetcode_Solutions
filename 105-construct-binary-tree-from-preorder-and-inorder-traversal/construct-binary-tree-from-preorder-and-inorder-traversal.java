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
    int preOrderIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return createTree(preorder,inorder,0,inorder.length-1,map);
    }
    public TreeNode createTree(int[] preorder,int[] inorder,int left,int right,Map<Integer,Integer> map){
        if(left>right) return null;
        TreeNode root=new TreeNode(preorder[preOrderIndex++]);
        int i=map.get(root.val);
        root.left=createTree(preorder,inorder,left,i-1,map);
        root.right=createTree(preorder,inorder,i+1,right,map);
        return root;
    }
}