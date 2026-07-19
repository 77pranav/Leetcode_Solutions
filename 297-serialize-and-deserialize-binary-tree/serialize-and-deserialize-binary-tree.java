/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "null";
        ArrayList<String> strs=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node==null){
                    strs.add("null");
                    continue;
                }else{
                    strs.add(String.valueOf(node.val));
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return String.join(",",strs);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs=data.split(",");
        if(strs[0].equals("null")) return null;
        TreeNode root=new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int index=1;
        while(!queue.isEmpty() && index<strs.length){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(index<strs.length && !strs[index].equals("null")){
                    node.left=new TreeNode(Integer.parseInt(strs[index]));
                    queue.offer(node.left);
                }
                index++;
                if(index<strs.length && !strs[index].equals("null")){
                    node.right=new TreeNode(Integer.parseInt(strs[index]));
                    queue.offer(node.right);
                }
                index++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));