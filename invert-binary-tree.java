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
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        
        TreeNode leftSide = root.left;
        TreeNode rightSide = root.right;
        if (root.left != null) leftSide = invertTree(leftSide);
        if (root.right != null) rightSide = invertTree(rightSide);
        
        root.right = leftSide;
        root.left = rightSide;
        
        return root;
    }
}
