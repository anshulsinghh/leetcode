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
    boolean balanced;
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        helper(root);
        return balanced;
    }
    
    public int helper(TreeNode n) {
        if (n == null) return 0;
        if (!balanced) return 0;
        
        int leftHeight = helper(n.left);
        int rightHeight = helper(n.right);
        
        if (Math.abs(leftHeight-rightHeight) > 1) {
            balanced = false;
            return 0;
        }
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
