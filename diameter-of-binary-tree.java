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
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans-1;
    }
    
    public int dfs(TreeNode n) {
        if (n == null) return 0;
        
        int leftHeight = dfs(n.left);
        int rightHeight = dfs(n.right);
        
        int bestHere = 1 + leftHeight + rightHeight;
        ans = Math.max(bestHere, ans);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
