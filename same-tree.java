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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        
        if (isLeaf(p) && isLeaf(q) && p.val == q.val) return true;
        else if (isLeaf(p) || isLeaf(q)) return false;
        else if (p.val != q.val) return false;

        boolean leftSame = isSameTree(p.left, q.left);
        boolean rightSame = isSameTree(p.right, q.right);
        
        return p.val == q.val && leftSame && rightSame;
    }
    
    public boolean isLeaf(TreeNode n) {
        if (n == null) return false;
        return n.left == null && n.right == null;
    }
}
