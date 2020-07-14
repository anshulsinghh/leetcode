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
    public List<List<Integer>> res;
    public int height;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        height = -1;
        populate(root, 0);
        return res;
    }
    
    public void populate(TreeNode node, int level) {
        if (node == null) return;
        if (height < level) {
            res.add(new ArrayList<Integer>());
            height++;
        }
        
        populate(node.left, level + 1);
        
        res.get(level).add(node.val);
        
        populate(node.right, level + 1);
    }
}
