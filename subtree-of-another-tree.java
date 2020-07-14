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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return s == t;
        return isSubtree(s.right, t) || isSubtree(s.left, t) || isSameTree(s, t);
    }
    
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return s == t;
        return (s.val == t.val) && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
