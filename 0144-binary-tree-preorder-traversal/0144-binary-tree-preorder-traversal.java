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
    // public void preorder(TreeNode root,List<Integer> ans){
    //     if(root==null)
    //         return;
    //     ans.add(root.val);
    //     preorder(root.left,ans);
    //     preorder(root.right,ans);
    // }

    public List<Integer> preorderTraversal(TreeNode root) {
        // List<Integer> ans = new ArrayList<>();
        // preorder(root,ans);
        // return ans;
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred = curr.left;
                while(pred.right!=null) 
                    pred=pred.right;
                pred.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            ans.add(curr.val);
            curr=curr.right;
        }
        return ans;
    }
}