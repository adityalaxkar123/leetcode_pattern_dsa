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
class Pair{
    TreeNode node;
    boolean isLeft;
    Pair(TreeNode node,boolean isLeft){
        this.node=node;
        this.isLeft=isLeft;
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        q.add(new Pair(root,false));
        while(!q.isEmpty()){
            Pair p = q.remove();
            if(p.node.left==null && p.node.right==null && p.isLeft)
                ans+=p.node.val;
            
            if(p.node.left!=null)
                q.add(new Pair(p.node.left,true));
            if(p.node.right!=null)
                q.add(new Pair(p.node.right,false));
        }

        return ans;
    }
}