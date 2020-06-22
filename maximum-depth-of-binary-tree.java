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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null) {
            leftDepth = 1 + maxDepth(root.left);
        }
        
        if (root.right != null) {
            rightDepth = 1 + maxDepth(root.right);
        }
        
        if (leftDepth >= rightDepth) return leftDepth;
        
        return rightDepth;    
    }
}
