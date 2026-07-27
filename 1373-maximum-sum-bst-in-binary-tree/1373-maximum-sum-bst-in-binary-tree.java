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
class Info{
    boolean isBST;
    int mn,mx,sum;
    Info(boolean isBST,int mn,int mx,int sum){
        this.isBST = isBST;
        this.mn=mn;
        this.mx=mx;
        this.sum=sum;
    }
}

class Solution {
    int ans=0;
    public Info helper(TreeNode root){
        if(root==null)
            return new Info(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        
        Info left = helper(root.left);
        Info right = helper(root.right);

        if(left.isBST && right.isBST && root.val>left.mx && root.val<right.mn){
            int sum = left.sum+right.sum+root.val;
            ans=Math.max(ans,sum);
            int mn = Math.min(root.val,left.mn);
            int mx = Math.max(root.val,right.mx);
            return new Info(true,mn,mx,sum);
        }
        return new Info(false,0,0,0);
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }
}