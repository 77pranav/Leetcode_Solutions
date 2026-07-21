/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Map<TreeNode,List<TreeNode>> map=new HashMap<>();
        helperMap(root,map,null);
        Queue<TreeNode> queue=new LinkedList<>();
        Set<TreeNode> set=new HashSet<>();
        queue.offer(target);
        set.add(target);
        while(!queue.isEmpty() && k>0){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(!map.containsKey(node)) continue;
                for(TreeNode key:map.get(node)){
                    if(!set.contains(key)){
                        queue.offer(key);
                        set.add(key);
                    }
                }
            }
            k--;
        }
        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }
        return result;
    }
    public void helperMap(TreeNode root,Map<TreeNode,List<TreeNode>> map,TreeNode parent){
        if(root==null) return;
        if(parent!=null) map.put(root,new ArrayList<>(List.of(parent)));
        if(root.left!=null){
            if(map.containsKey(root)){
                map.get(root).add(root.left);
            }else{
                map.put(root,new ArrayList<>(List.of(root.left)));
            }
        }
        if(root.right!=null){
            if(map.containsKey(root)){
                map.get(root).add(root.right);
            }else{
                map.put(root,new ArrayList<>(List.of(root.right)));
            }
        }
        helperMap(root.left,map,root);
        helperMap(root.right,map,root);
    }
}