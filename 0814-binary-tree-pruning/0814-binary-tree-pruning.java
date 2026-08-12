class Solution {
    public boolean helper(TreeNode root){
        if(root==null)
            return true;
        if(root.left==null && root.right==null && root.val==0)
            return true;
        
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if(left)
            root.left=null;
        if(right)
            root.right=null;
        if(left && right && root.val==0)
            return true;
        return false;
    }

    public TreeNode pruneTree(TreeNode root) {
        boolean res = helper(root);
        return (res)?null:root;        
    }
}