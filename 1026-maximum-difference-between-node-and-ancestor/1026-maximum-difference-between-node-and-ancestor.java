class Pair {
    TreeNode node;
    int min, max;
    Pair(TreeNode n,int mx,int mi){
        node=n;
        min=mi;
        max=mx;
    }
}

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        q.add(new Pair(root,root.val,root.val));
        while(!q.isEmpty()){
            Pair curr = q.remove();
            ans=Math.max(ans,Math.max(Math.abs(curr.max-curr.node.val),Math.abs(curr.min-curr.node.val)));
            if(curr.node.left!=null){
                q.add(new Pair(curr.node.left,Math.max(curr.max,curr.node.val),Math.min(curr.min,curr.node.val)));
            }
            if(curr.node.right!=null){
                q.add(new Pair(curr.node.right,Math.max(curr.max,curr.node.val),Math.min(curr.min,curr.node.val)));
            }

        }
        return ans;
    }
}