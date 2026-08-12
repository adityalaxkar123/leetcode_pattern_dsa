class Solution {
    public int helper(TreeNode root,int turn,HashMap<TreeNode,int[]> dp){
        if(root==null || root.left==null && root.right==null)
            return 0;
        if(dp.get(root)!=null && dp.get(root)[turn-1]!=-1)
            return dp.get(root)[turn-1];
        int left =0,right=0;    
        // if(turn==-1){
        //     if(root.left!=null)
        //         left=1+helper(root.left,1,dp);
        //     if(root.right!=null)
        //         right=1+helper(root.right,0,dp);
        // }
        if(turn==1){
            if(root.left!=null)
                left=1+helper(root.left,2,dp);
        }else{
            if(root.right!=null)
                right=1+helper(root.right,1,dp);
        }
        if(!dp.containsKey(root)){
            dp.put(root,new int[]{-1,-1});
        }
        dp.get(root)[turn-1]=Math.max(left,right);
        return Math.max(left,right);
    }

    public int longestZigZag(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode,int[]> dp = new HashMap<>();
        q.add(root);
        int len = 0;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            len = Math.max(len,Math.max(helper(curr,1,dp),helper(curr,2,dp)));
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
        return len;
    }
}